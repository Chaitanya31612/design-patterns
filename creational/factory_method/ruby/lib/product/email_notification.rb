# frozen_string_literal: true

# EmailNotification is a concrete product that implements the Notification interface
class EmailNotification < Notification
  def send(recipient, message)
    puts "Sending email to #{recipient}: #{message}"
  end
end
