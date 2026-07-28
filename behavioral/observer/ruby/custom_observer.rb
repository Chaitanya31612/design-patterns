# frozen_string_literal: true

# Custom implementation of the Observer pattern using a Ruby Module/Mixin.
# This approach leverages Ruby's duck typing and block/closure support.

module Subject
  # Accessor for observers list, using lazy initialization
  def observers
    @observers ||= []
  end

  # Accessor for block callbacks, using lazy initialization
  def callbacks
    @callbacks ||= []
  end

  # Register a standard observer object
  def register_observer(observer)
    observers << observer unless observers.include?(observer)
  end

  # Remove a standard observer object
  def remove_observer(observer)
    observers.delete(observer)
  end

  # Register a block/callback observer (Ruby's superpower)
  def on_update(&block)
    callbacks << block if block_given?
  end

  # Notify all registered observers (both objects and blocks)
  def notify_observers
    # Notify standard observer objects (Pull Model: passing self)
    observers.each { |observer| observer.update(self) }

    # Notify block callbacks
    callbacks.each { |callback| callback.call(self) }
  end
end

# Concrete Subject
class User
  include Subject

  attr_reader :name, :latest_post

  def initialize(name)
    @name = name
    @latest_post = nil
  end

  # Simulates publishing a new post
  def publish_post(content)
    puts "\n[#{name}] Publishing new post: \"#{content}\""
    @latest_post = content
    notify_observers
  end
end

# Concrete Observer
class Subscriber
  attr_reader :name

  def initialize(name)
    @name = name
  end

  # Duck typing: Implementing the expected update method
  def update(subject)
    if subject.respond_to?(:latest_post) && subject.respond_to?(:name)
      puts "#{name}'s feed updated: #{subject.name} posted: \"#{subject.latest_post}\""
    else
      puts "#{name} received notification from unknown subject"
    end
  end
end
