package creator;

import product.Button;
import product.CheckBox;
import product.MacButton;
import product.MacCheckBox;

public class MacWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
