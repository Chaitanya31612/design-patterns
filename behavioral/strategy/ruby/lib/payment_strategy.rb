# Base strategy class (Interface simulation in Ruby)
class PaymentStrategy
  # Enforce the strategy interface contract.
  # Ruby does not have interface keywords, so raising NotImplementedError
  # is the standard way to enforce abstract method execution.
  def pay(amount)
    raise NotImplementedError, "#{self.class} must implement #pay(amount)"
  end
end
