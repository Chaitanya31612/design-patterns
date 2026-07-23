require_relative 'payment_strategy'

class CreditCardPaymentStrategy < PaymentStrategy
  attr_reader :card_number, :cvv, :expiry_date

  def initialize(card_number, cvv, expiry_date)
    @card_number = card_number
    @cvv = cvv
    @expiry_date = expiry_date
  end

  # Overrides PaymentStrategy#pay
  def pay(amount)
    puts "Paying #{amount} via Credit Card with number #{card_number}"
    true
  end
end
