# frozen_string_literal: true

require 'delegate'

# The Base Component
class SimpleText
  attr_reader :content

  def initialize(content)
    @content = content
  end

  # Returns the plain text content
  def render
    @content
  end

  # An extra method to demonstrate delegation
  def length
    @content.length
  end
end

# The Base Decorator using Ruby's SimpleDelegator
# SimpleDelegator automatically forwards any method call it doesn't implement
# to the wrapped object (retrieved via `__getobj__`).
class TextDecorator < SimpleDelegator
  # By default, delegate the render method to the wrapped component
  def render
    __getobj__.render
  end
end

# Concrete Decorator: Bold
class BoldDecorator < TextDecorator
  def render
    "<b>#{super}</b>"
  end
end

# Concrete Decorator: Italic
class ItalicDecorator < TextDecorator
  def render
    "<i>#{super}</i>"
  end
end

# Concrete Decorator: Underline
class UnderlineDecorator < TextDecorator
  def render
    "<u>#{super}</u>"
  end
end
