
require_relative '../product/sms_notification'

class SmsNotificationSender < NotificationSender
  def create_notification
    SmsNotification.new
  end
end
