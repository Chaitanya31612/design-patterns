# frozen_string_literal: true

require_relative 'insert_text_command'
require_relative 'delete_text_command'

class TextEditor
  def initialize
    @undo_stack = []
    @redo_stack = []
    @document = Document.new
  end

  def insert(text)
    insert_command = InsertTextCommand.new(@document, text)
    insert_command.execute
    @undo_stack << insert_command
    @redo_stack.clear
  end

  def delete(count)
    delete_command = DeleteTextCommand.new(@document, count)
    delete_command.execute
    @undo_stack << delete_command
    @redo_stack.clear
  end

  def undo
    return unless @undo_stack.any?

    command = @undo_stack.pop
    command.undo
    @redo_stack << command
  end

  def redo
    return unless @redo_stack.any?

    command = @redo_stack.pop
    command.execute
    @undo_stack << command
  end
end
