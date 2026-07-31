# frozen_string_literal: true

class Document
  attr_reader :content

  def initialize
    @content = ''
  end

  def append(text)
    @content += text
  end

  def delete_last(count)
    deleted = @content[-count...]
    @content = @content[0...-count]
    deleted
  end
end
