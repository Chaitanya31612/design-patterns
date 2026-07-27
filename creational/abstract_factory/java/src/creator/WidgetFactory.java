
package creator;

import product.Button;
import product.CheckBox;

public interface WidgetFactory {
    public abstract Button createButton();
    public abstract CheckBox createCheckBox();
}
