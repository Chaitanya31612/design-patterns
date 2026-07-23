require_relative 'payment_strategy'

class PaypalPaymentStrategy < PaymentStrategy
  attr_reader :email

  def initialize(email)
    @email = email
  end

  # Overrides PaymentStrategy#pay
  def pay(amount)
    # Put verification or authorization logic here
    puts "Paying #{amount} via Paypal with email #{email}"
    true
  end
end
