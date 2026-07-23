public class Main {
  public static void main(String[] args) {
    String cardNumber = "4242424242424242"; // 16 digits
    String cvv = "000"; // 3 digits
    String expiryDate = "01/29"; // MM/YY
    PaymentProcessor processor = new PaymentProcessor(new CreditCardPaymentStrategy(cardNumber, cvv, expiryDate));

    System.err.println("Trying to pay 100...");
    if (processor.pay(100)) {
      System.err.println("Payment successful!");
    } else {
      System.err.println("Payment failed.");
    }

    // now changing to UPI
    processor.setPaymentStrategy(new UPIPaymentStrategy("1234567890@upi"));

    System.err.println("Trying to pay 200...");
    if (processor.pay(200)) {
      System.err.println("Payment successful!");
    } else {
      System.err.println("Payment failed.");
    }
  }
}
