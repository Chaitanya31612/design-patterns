# frozen_string_literal: true

require_relative 'custom_observer'
require_relative 'stdlib_observer'

def run_custom_demo
  puts "=================================================="
  puts "         Demo 1: Custom Observer Logic"
  puts "=================================================="

  alice = User.new("Alice")
  chaitanya = Subscriber.new("Chaitanya")
  guptaji = Subscriber.new("Guptaji")

  # 1. Register standard object observers
  alice.register_observer(chaitanya)
  alice.register_observer(guptaji)

  # 2. Register a block-based observer (Ruby's closure power)
  alice.on_update do |user|
    puts "Block Callback: [LOG] #{user.name} updated their feed with \"#{user.latest_post}\""
  end

  # 3. Publish first post
  alice.publish_post("Exploring the beauty of Ruby mixins!")

  # 4. Remove an observer and publish again
  alice.remove_observer(guptaji)
  alice.publish_post("Writing clean design patterns.")
end

def run_stdlib_demo
  puts "\n=================================================="
  puts "    Demo 2: Ruby Standard Library Observable"
  puts "=================================================="

  bob = StdlibUser.new("Bob")
  chaitanya = StdlibSubscriber.new("Chaitanya")
  guptaji = StdlibSubscriber.new("Guptaji")

  # 1. Register observers using standard library method `add_observer`
  bob.add_observer(chaitanya)
  bob.add_observer(guptaji)

  # 2. Publish first post
  bob.publish_post("Learning built-in modules in Ruby stdlib.")

  # 3. Remove an observer using standard library method `delete_observer`
  bob.delete_observer(guptaji)
  bob.publish_post("Enjoying clean syntax!")
end

run_custom_demo
run_stdlib_demo
