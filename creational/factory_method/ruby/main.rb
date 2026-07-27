require_relative 'simple_notification_sender_factory'

def run_demo
  print 'Enter notification type (sms/email/whatsapp): '
  notification_type = gets.chomp

  print 'Enter message: '
  message = gets.chomp

  print 'Enter sender: '
  sender_name = gets.chomp

  sender = SimpleNotificationSenderFactory.create_sender(notification_type)
  sender.send_notification(sender_name, message)
end

if __FILE__ == $PROGRAM_NAME
  run_demo
end
