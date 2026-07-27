
require_relative '../product/email_notification'

class EmailNotificationSender < NotificationSender
  def create_notification
    EmailNotification.new
  end
end
