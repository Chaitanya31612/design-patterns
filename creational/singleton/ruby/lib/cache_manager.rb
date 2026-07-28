# frozen_string_literal: true

require 'singleton'
require 'thread'

class CacheManager
  include Singleton

  def initialize
    @store = {}
    @lock = Mutex.new
  end

  # Write to cache
  def write(key, value)
    @lock.synchronize do
      @store[key] = value
    end
  end

  # Read from cache
  def read(key)
    @lock.synchronize do
      @store[key]
    end
  end

  # Delete a key from cache
  def delete(key)
    @lock.synchronize do
      @store.delete(key)
    end
  end

  # Clear all cached items
  def clear
    @lock.synchronize do
      @store.clear
    end
  end

  # Check if key exists in cache
  def key?(key)
    @lock.synchronize do
      @store.key?(key)
    end
  end

  # Idiomatic syntax sugar: allows cache_instance[key] = value
  alias []= write

  # Idiomatic syntax sugar: allows cache_instance[key]
  alias [] read
end
