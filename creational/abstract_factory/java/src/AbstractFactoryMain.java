import creator.*;
import product.*;
import java.util.*;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            WidgetFactory widgetFactory;

            System.out.println("Enter platform (mac/windows):");
            String platform = sc.nextLine();

            if (platform.equals("mac")) {
                widgetFactory = new MacWidgetFactory();
            } else {
                widgetFactory = new WindowsWidgetFactory();
            }

            Button button = widgetFactory.createButton();
            CheckBox checkBox = widgetFactory.createCheckBox();

            renderUI(button, checkBox);
        }
    }

    private static void renderUI(Button button, CheckBox checkBox) {
        System.out.println("Rendering UI...");
        button.render();
        checkBox.render();
        System.out.println("UI rendered.");
    }
}
