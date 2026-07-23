public class PaymentProcessor {
  private PaymentStrategy paymentStrategy;

  public PaymentProcessor(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }

  public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }

  public boolean pay(double amount) {
    return paymentStrategy.pay(amount);
  }
}
