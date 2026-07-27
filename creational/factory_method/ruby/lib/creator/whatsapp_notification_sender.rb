require_relative '../product/whatsapp_notification'

class WhatsappNotificationSender < NotificationSender
  def create_notification
    WhatsAppNotification.new
  end
end
