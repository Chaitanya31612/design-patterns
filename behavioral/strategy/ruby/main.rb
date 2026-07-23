require_relative 'lib/payment_processor'
require_relative 'lib/credit_card_payment_strategy'
require_relative 'lib/paypal_payment_strategy'
require_relative 'lib/upi_payment_strategy'

def run_demo
  # 1. Initialize Credit Card Strategy
  card_number = "4242424242424242"
  cvv = "000"
  expiry_date = "01/29"
  
  card_strategy = CreditCardPaymentStrategy.new(card_number, cvv, expiry_date)
  processor = PaymentProcessor.new(card_strategy)

  puts "Trying to pay 100..."
  if processor.pay(100)
    puts "Payment successful!"
  else
    puts "Payment failed."
  end

  puts "-" * 40

  # 2. Dynamically swap strategy to UPI
  upi_strategy = UpiPaymentStrategy.new("1234567890@upi")
  processor.payment_strategy = upi_strategy

  puts "Trying to pay 200..."
  if processor.pay(200)
    puts "Payment successful!"
  else
    puts "Payment failed."
  end
end

if __FILE__ == $PROGRAM_NAME
  run_demo
end
