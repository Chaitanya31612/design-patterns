package condiments;

import beverage.Beverage;

public class Milk extends CondimentsDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "with Milk";
    }
}
