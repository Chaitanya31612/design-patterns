# frozen_string_literal: true

# A custom implementation of the Observer pattern modeling a social network.
# Here, a single User class acts as both a Subject (can have followers)
# and an Observer (can follow other users).

module Subject
  # Lazy-initialized array of followers (observers)
  def followers
    @followers ||= []
  end

  # Register a follower
  def register_follower(follower)
    # Check if the follower responds to the update method (duck typing)
    unless follower.respond_to?(:update)
      raise ArgumentError, "Follower must implement an #update method"
    end
    followers << follower unless followers.include?(follower)
  end

  # Unregister a follower
  def remove_follower(follower)
    followers.delete(follower)
  end

  # Notify all followers of the update
  def notify_followers
    followers.each { |follower| follower.update(self) }
  end
end

class User
  include Subject

  attr_reader :name, :latest_post, :timeline

  def initialize(name)
    @name = name
    @timeline = [] # Home timeline containing posts of followed users
    @latest_post = nil
  end

  # Follows another user (subscribes to their updates)
  def follow(other_user)
    raise ArgumentError, "Cannot follow yourself" if other_user == self

    other_user.register_follower(self)
    puts "#{name} is now following #{other_user.name}."
  end

  # Unfollows another user (unsubscribes from their updates)
  def unfollow(other_user)
    other_user.remove_follower(self)
    puts "#{name} unfollowed #{other_user.name}."
  end

  # Publishes a post and triggers notifications
  def publish_post(content)
    puts "\n[#{name}] Posted: \"#{content}\""
    @latest_post = content
    notify_followers
  end

  # Observer Callback: Triggered when a followed user publishes a post (Pull model)
  def update(publisher)
    post_entry = "#{publisher.name}: #{publisher.latest_post}"
    @timeline << post_entry
    puts "  -> #{name}'s timeline received: \"#{post_entry}\""
  end
end

# Demo/Runner
def run_social_network_demo
  puts "=================================================="
  puts "    Demo: Self-Referential Social Network (Observer)"
  puts "=================================================="

  # Create users
  alice = User.new("Alice")
  bob = User.new("Bob")
  charlie = User.new("Charlie")

  # Setup follow relationships
  puts "--- Setting Up Relationships ---"
  bob.follow(alice)      # Bob follows Alice
  charlie.follow(alice)  # Charlie follows Alice
  charlie.follow(bob)    # Charlie follows Bob
  puts "--------------------------------\n"

  # Alice publishes a post -> Bob and Charlie should be notified
  alice.publish_post("Enjoying a sunny day in San Francisco!")

  # Bob publishes a post -> Charlie should be notified
  bob.publish_post("Just finished writing a custom Observer in Ruby.")

  # Charlie publishes a post -> No one is following Charlie, so no notifications
  charlie.publish_post("Enjoying quiet time.")

  # Bob unfollows Alice
  puts "\n--- Changing Relationships ---"
  bob.unfollow(alice)
  puts "------------------------------\n"

  # Alice publishes another post -> Only Charlie should be notified (Bob unfollowed)
  alice.publish_post("Ruby is incredibly elegant!")

  # Print final timelines
  puts "\n--- Final Timelines ---"
  puts "Alice's Timeline: #{alice.timeline}"
  puts "Bob's Timeline: #{bob.timeline}"
  puts "Charlie's Timeline: #{charlie.timeline}"
end

if __FILE__ == $PROGRAM_NAME
  run_social_network_demo
end

# =begin
# ❯ ruby ../behavioral/observer/ruby/social_network.rb
# ==================================================
#     Demo: Self-Referential Social Network (Observer)
# ==================================================
# --- Setting Up Relationships ---
# Bob is now following Alice.
# Charlie is now following Alice.
# Charlie is now following Bob.
# --------------------------------

# [Alice] Posted: "Enjoying a sunny day in San Francisco!"
#   -> Bob's timeline received: "Alice: Enjoying a sunny day in San Francisco!"
#   -> Charlie's timeline received: "Alice: Enjoying a sunny day in San Francisco!"

# [Bob] Posted: "Just finished writing a custom Observer in Ruby."
#   -> Charlie's timeline received: "Bob: Just finished writing a custom Observer in Ruby."

# [Charlie] Posted: "Enjoying quiet time."

# --- Changing Relationships ---
# Bob unfollowed Alice.
# ------------------------------

# [Alice] Posted: "Ruby is incredibly elegant!"
#   -> Charlie's timeline received: "Alice: Ruby is incredibly elegant!"

# --- Final Timelines ---
# Alice's Timeline: []
# Bob's Timeline: ["Alice: Enjoying a sunny day in San Francisco!"]
# Charlie's Timeline: ["Alice: Enjoying a sunny day in San Francisco!", "Bob: Just finished writing a custom Observer in Ruby.", "Alice: Ruby is incredibly elegant!"]
# = end
