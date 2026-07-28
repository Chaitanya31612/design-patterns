import beverage.Espresso;
import beverage.Beverage;
import condiments.Mocha;
import condiments.Milk;

public class DecoratorMain {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.getDescription() + " $" + beverage.getCost());
    }
}
