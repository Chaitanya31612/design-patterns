package condiments;

import beverage.Beverage;

public class Mocha extends CondimentsDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " - Mocha";
    }
}
