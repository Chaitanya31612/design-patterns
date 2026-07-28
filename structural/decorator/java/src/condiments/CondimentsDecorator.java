package condiments;

import beverage.Beverage;

public abstract class CondimentsDecorator implements Beverage {
    protected Beverage beverage;

    public CondimentsDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
