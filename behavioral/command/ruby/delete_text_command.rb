# frozen_string_literal: true

require_relative 'document'
require_relative 'command'

class DeleteTextCommand < Command
  def initialize(document, delete_count)
    super()
    @document = document
    @delete_count = delete_count
  end

  def execute
    @deleted_text = @document.delete_last(@delete_count)
    puts "Deleted #{@delete_count} characters"
    puts "Current content: #{@document.content}"
  end

  def undo
    return unless @delete_count

    @document.append(@deleted_text)
    puts "Undid delete: #{@deleted_text}"
    puts "Current content: #{@document.content}"
  end
end
