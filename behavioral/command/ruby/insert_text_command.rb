# frozen_string_literal: true

require_relative 'document'
require_relative 'command'

class InsertTextCommand < Command
  def initialize(document, text)
    super()
    @document = document
    @text = text
  end

  def execute
    @document.append(@text)
    puts "Inserted #{@text}"
    puts "Current content: #{@document.content}"
  end

  def undo
    return unless @text

    @document.delete_last(@text.length)
    puts "Undid insert of #{@text}"
    puts "Current content: #{@document.content}"
  end
end
