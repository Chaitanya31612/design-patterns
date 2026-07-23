public class CreditCardPaymentStrategy implements PaymentStrategy {
  private String cardNumber;
  private String cvv;
  private String expiryDate;

  public CreditCardPaymentStrategy(String cardNumber, String cvv, String expiryDate) {
    this.cardNumber = cardNumber;
    this.cvv = cvv;
    this.expiryDate = expiryDate;
  }

  @Override
  public boolean pay(double amount) {
    System.out.println("Paying " + amount + " via Credit Card with number " + cardNumber);
    return true;
  }
}
