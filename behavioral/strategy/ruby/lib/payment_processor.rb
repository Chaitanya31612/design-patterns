class PaymentProcessor
  # attr_accessor automatically creates getter and setter methods
  # equivalent to getPaymentStrategy() and setPaymentStrategy() in Java.
  attr_accessor :payment_strategy

  def initialize(payment_strategy)
    @payment_strategy = payment_strategy
  end

  # Delegates payment logic to the configured strategy object
  def pay(amount)
    payment_strategy.pay(amount)
  end
end
