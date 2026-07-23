public class UPIPaymentStrategy implements PaymentStrategy {
  private String upiId;

  public UPIPaymentStrategy(String upiId) {
    this.upiId = upiId;
  }

  @Override
  public boolean pay(double amount) {
    System.out.println("Paying " + amount + " via UPI with ID " + upiId);
    return true;
  }
}
