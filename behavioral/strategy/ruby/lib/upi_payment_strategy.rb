require_relative 'payment_strategy'

class UpiPaymentStrategy < PaymentStrategy
  attr_reader :upi_id

  def initialize(upi_id)
    @upi_id = upi_id
  end

  # Overrides PaymentStrategy#pay
  def pay(amount)
    puts "Paying #{amount} via UPI with ID #{upi_id}"
    true
  end
end
