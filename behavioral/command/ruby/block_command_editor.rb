# frozen_string_literal: true

require_relative 'document'

# BlockCommand encapsulates execution and undo logic using Ruby Procs/Lambdas.
# This eliminates the need to create separate class files for every command.
class BlockCommand
  def initialize(execute_proc, undo_proc)
    @execute_proc = execute_proc
    @undo_proc = undo_proc
  end

  def execute
    @execute_proc.call
  end

  def undo
    @undo_proc.call
  end
end

# DynamicTextEditor acts as the Invoker managing undo/redo stacks.
# It allows executing arbitrary commands specified as blocks/lambdas.
class DynamicTextEditor
  attr_reader :document, :undo_stack, :redo_stack

  def initialize(document = Document.new)
    @document = document
    @undo_stack = []
    @redo_stack = []
  end

  # Executes a dynamic command defined by an execute block and an undo Proc/Lambda.
  # Usage:
  #   editor.execute_command(
  #     execute: -> { document.append("Hello") },
  #     undo:    -> { document.delete_last(5) }
  #   )
  def execute_command(execute:, undo:)
    command = BlockCommand.new(execute, undo)
    command.execute
    @undo_stack << command
    @redo_stack.clear
  end

  # Convenient block-based syntax for executing operations:
  #   editor.execute(undo: -> { document.delete_last(text.length) }) do
  #     document.append(text)
  #   end
  def execute(undo: nil, &execute_block)
    raise ArgumentError, 'An execute block must be provided' unless block_given?
    raise ArgumentError, 'An undo proc/lambda must be provided' unless undo.respond_to?(:call)

    execute_command(execute: execute_block, undo: undo)
  end

  # High-level helper for inserting text using closures
  def insert(text)
    execute(undo: -> { @document.delete_last(text.length) }) do
      @document.append(text)
      puts "Inserted: '#{text}'"
      puts "Current content: '#{@document.content}'"
    end
  end

  # High-level helper for deleting text using closures to capture deleted state dynamically
  def delete(count)
    deleted_text = nil
    execute(undo: -> { @document.append(deleted_text) }) do
      deleted_text = @document.delete_last(count)
      puts "Deleted #{count} chars: '#{deleted_text}'"
      puts "Current content: '#{@document.content}'"
    end
  end

  def undo
    unless @undo_stack.any?
      puts 'Nothing to undo.'
      return
    end

    command = @undo_stack.pop
    command.undo
    @redo_stack << command
    puts "Undid last operation. Current content: '#{@document.content}'"
  end

  def redo
    unless @redo_stack.any?
      puts 'Nothing to redo.'
      return
    end

    command = @redo_stack.pop
    command.execute
    @undo_stack << command
    puts "Redid last operation. Current content: '#{@document.content}'"
  end
end

# --- Demonstration of Block/Lambda Command Pattern ---
if __FILE__ == $PROGRAM_NAME
  puts "=== Ruby Dynamic Block/Lambda Command Pattern Demo ==="
  document = Document.new
  editor = DynamicTextEditor.new(document)

  puts "\n1. High-level operations using dynamic block commands:"
  editor.insert("Hello")
  editor.insert(", World!")

  puts "\n2. Performing Undo & Redo:"
  editor.undo
  editor.redo

  puts "\n3. Deleting text & Undo/Redo:"
  editor.delete(8)
  editor.undo

  puts "\n4. Custom ad-hoc block command without writing a new Command class:"
  # E.g. uppercase all text with an undo block that restores original text
  original_text = nil
  editor.execute(undo: -> { document.instance_variable_set(:@content, original_text) }) do
    original_text = document.content.dup
    document.instance_variable_set(:@content, document.content.upcase)
    puts "Custom Command Executed: Uppercased entire document!"
    puts "Current content: '#{document.content}'"
  end

  puts "\n5. Undo custom ad-hoc command:"
  editor.undo
end
