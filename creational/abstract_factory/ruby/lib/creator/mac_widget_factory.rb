require_relative '../product/mac_button'
require_relative '../product/mac_checkbox'
require_relative './widget_factory'


class MacWidgetFactory < WidgetFactory
  def create_button
    MacButton.new
  end

  def create_checkbox
    MacCheckbox.new
  end
end
