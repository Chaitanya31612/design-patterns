class WidgetFactory
  def create_button
    raise NotImplementedError, "create_button must be implemented"
  end

  def create_checkbox
    raise NotImplementedError, "create_checkbox must be implemented"
  end
end
