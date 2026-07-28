# frozen_string_literal: true

require_relative 'lib/text_components'

# Demonstrates basic decorator formatting
def show_basic_styles
  plain_text = SimpleText.new('Hello, World!')
  puts "Plain Text:     #{plain_text.render}"
  puts "Plain Length:   #{plain_text.length} characters"
  puts '--------------------------------------------------'

  bold_text = BoldDecorator.new(plain_text)
  puts "Bold Render:    #{bold_text.render}"
  puts '--------------------------------------------------'

  bold_italic_text = ItalicDecorator.new(bold_text)
  puts "Bold+Italic:    #{bold_italic_text.render}"
  puts '--------------------------------------------------'
end

# Demonstrates deep stacking and delegation
def show_delegation_power
  fully_styled = UnderlineDecorator.new(
    BoldDecorator.new(
      ItalicDecorator.new(SimpleText.new('Design Patterns'))
    )
  )
  puts "Fully Styled:   #{fully_styled.render}"
  puts '--------------------------------------------------'

  puts 'Calling delegated methods through the decorator chain:'
  puts "  Length of 'Design Patterns': #{fully_styled.length} characters"
  puts "  Original raw content:        '#{fully_styled.content}'"
end

# Entry point for the demo
def run_decorator_demo
  puts '=================================================='
  puts '        Demo: HTML Text Editor Decorator'
  puts '=================================================='
  show_basic_styles
  show_delegation_power
end

run_decorator_demo
