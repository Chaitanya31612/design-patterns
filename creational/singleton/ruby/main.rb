# frozen_string_literal: true

require_relative 'lib/cache_manager'

def run_demo
  # 1. Access the singleton instance
  cache1 = CacheManager.instance
  cache2 = CacheManager.instance

  puts "Are cache1 and cache2 the same object? #{cache1.equal?(cache2)} (Object ID: #{cache1.object_id})"

  # 2. Verify that instantiation and duplication are disabled
  begin
    CacheManager.new
  rescue NoMethodError => e
    puts "Instantiation (.new) failed as expected: #{e.message}"
  end

  begin
    cache1.dup
  rescue TypeError => e
    puts "Duplication (.dup) failed as expected: #{e.message}"
  end

  begin
    cache1.clone
  rescue TypeError => e
    puts "Cloning (.clone) failed as expected: #{e.message}"
  end

  # 3. Simple usage
  cache1[:app_name] = "Ruby Singleton Cache"
  cache1[:status] = "Active"

  puts "\nReading from cache2 instance:"
  puts "  App Name: #{cache2[:app_name]}"
  puts "  Status:   #{cache2[:status]}"

  # 4. Multi-threaded test (500 concurrent operations)
  puts "\n--- Simulating concurrent writes with threads ---"
  threads = []

  10.times do |thread_idx|
    threads << Thread.new do
      50.times do |op_idx|
        cache1["key_t#{thread_idx}_o#{op_idx}"] = "Value #{op_idx}"
      end
    end
  end

  threads.each(&:join)
  
  # Inspect the underlying store size safely (using instance_variable_get for verification)
  store_size = cache1.instance_variable_get(:@store).size
  puts "Finished writing! Cache store size: #{store_size} (Expected: 502)"
end

run_demo
