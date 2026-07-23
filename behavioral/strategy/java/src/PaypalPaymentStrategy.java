public class PaypalPaymentStrategy implements PaymentStrategy {
  private String email;

  public PaypalPaymentStrategy(String email) {
    this.email = email;
  }

  @Override
  public boolean pay(double amount) {
    // can have logic around email verification
    // checking balance
    // bascially implementation of the algorithm

    System.out.println("Paying " + amount + " via Paypal with email " + email);
    return true;
  }
}
