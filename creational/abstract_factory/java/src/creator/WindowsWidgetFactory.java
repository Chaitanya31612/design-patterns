
package creator;

import product.Button;
import product.CheckBox;
import product.WindowsButton;
import product.WindowsCheckBox;


public class WindowsWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
