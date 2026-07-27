# frozen_string_literal: true

# SMSNotification is a concrete product that implements the Notification interface
class SMSNotification < Notification
  def send(recipient, message)
    puts "Sending SMS to #{recipient}: #{message}"
  end
end
