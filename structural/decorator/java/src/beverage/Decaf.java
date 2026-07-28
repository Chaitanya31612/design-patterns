package beverage;

public class Decaf implements Beverage {
    @Override
    public String getDescription() {
        return "Decaf Beverage";
    }

    @Override
    public double getCost() {
        return 1.99;
    }
}
