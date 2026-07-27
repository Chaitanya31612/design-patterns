
require_relative '../product/windows_button'
require_relative '../product/windows_checkbox'
require_relative './widget_factory'


class WindowsWidgetFactory < WidgetFactory
  def create_button
    WindowsButton.new
  end

  def create_checkbox
    WindowsCheckbox.new
  end
end
