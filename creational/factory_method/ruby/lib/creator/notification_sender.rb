require_relative '../product/notification'

class NotificationSender
  def send_notification(recipient, message)
    notification = create_notification
    puts "Sending notification: #{notification.class}"
    notification.send(recipient, message)
    puts "Notification sent successfully"
  end

  def create_notification()
    raise NotImplementedError, "Subclasses must implement this method"
  end
end
