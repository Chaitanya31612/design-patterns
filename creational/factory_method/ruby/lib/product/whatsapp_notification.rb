# frozen_string_literal: true

class WhatsAppNotification < Notification
  def send(recipient, message)
    puts "Sending WhatsApp to #{recipient}: #{message}"
  end
end
