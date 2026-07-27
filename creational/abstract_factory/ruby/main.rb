
require_relative './lib/creator/mac_widget_factory'
require_relative './lib/creator/windows_widget_factory'
require_relative './lib/product/button'
require_relative './lib/product/checkbox'


def run_demo
  widget_factory = MacWidgetFactory.new
  button = widget_factory.create_button
  check_box = widget_factory.create_checkbox
  render_ui(button, check_box)
end

def render_ui(button, check_box)
  puts "Rendering UI..."
  button.render
  check_box.render
  puts "UI rendered."
end

run_demo
