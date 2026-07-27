require_relative 'lib/creator/notification_sender'
require_relative 'lib/creator/sms_notification_sender'
require_relative 'lib/creator/email_notification_sender'
require_relative 'lib/creator/whatsapp_notification_sender'

class SimpleNotificationSenderFactory
  def self.create_sender(notification_type)
    case notification_type
    when 'sms'
      SmsNotificationSender.new
    when 'email'
      EmailNotificationSender.new
    when 'whatsapp'
      WhatsappNotificationSender.new
    else
      raise ArgumentError, "Unknown notification type: #{notification_type}"
    end
  end
end
