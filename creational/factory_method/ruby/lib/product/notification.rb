# abstract base class
class Notification
  def send(recipient, message)
    raise NotImplementedError, 'send must be implemented by subclasses'
  end
end
