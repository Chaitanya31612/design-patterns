# frozen_string_literal: true

# abstract base class
class Command
  def execute
    raise NotImplementedError
  end

  def undo
    raise NotImplementedError
  end
end
