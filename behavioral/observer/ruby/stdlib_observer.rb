# frozen_string_literal: true

require 'observer'

# Implementation using Ruby's built-in Observable module from the standard library.
# The stdlib Observable module provides:
# - add_observer(observer)
# - delete_observer(observer)
# - changed (sets a state-changed boolean flag to true)
# - notify_observers(*args)

# Concrete Subject including built-in Observable
class StdlibUser
  include Observable

  attr_reader :name, :latest_post

  def initialize(name)
    @name = name
    @latest_post = nil
  end

  def publish_post(content)
    puts "\n[#{name}] (Stdlib) Publishing new post: \"#{content}\""
    @latest_post = content
    
    # Crucial step: you MUST call `changed` before calling notify_observers.
    # The stdlib implementation uses this guard to filter out redundant/unwanted notifies.
    changed 
    
    # Notify observers (passing self as an argument to the observer's update method)
    notify_observers(self)
  end
end

# Concrete Observer
class StdlibSubscriber
  attr_reader :name

  def initialize(name)
    @name = name
  end

  # The standard library Observable expects the observer to implement `update` method.
  # Here we accept the subject object that notified us.
  def update(user)
    puts "#{name}'s feed updated: #{user.name} posted: \"#{user.latest_post}\""
  end
end
