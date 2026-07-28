
package design_patterns.creational.singleton.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// import design_patterns.creational.singleton.java.logger.Logger;
// import design_patterns.creational.singleton.java.double_check_logger.Logger;
import design_patterns.creational.singleton.java.bill_pugh_logger.Logger;


public class SingletonMain {
  public static void main(String[] args) throws InterruptedException, IOException {
    // enum singleton logic
    // Logger logger = Logger.CONSOLE_LOGGER;
    // logger.log("Hello, world for console!");

    // logger = Logger.FILE_LOGGER;
    // logger.log("Hello, world for file!");


    // Double check locking and Bill Pugh Singleton
    Logger consoleLogger = Logger.getConsoleLogger();
    Thread t1 = new Thread(() -> consoleLogger.log("Hello, world for console! From " + Thread.currentThread().getName()));
    Thread t2 = new Thread(() -> consoleLogger.log("Hello, world for console! From " + Thread.currentThread().getName()));
    Thread t3 = new Thread(() -> consoleLogger.log("Hello, world for console! From " + Thread.currentThread().getName()));

    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();

    Logger fileLogger = Logger.getFileLogger();
    Thread t4 = new Thread(() -> fileLogger.log("Hello, world for file! From " + Thread.currentThread().getName()));
    Thread t5 = new Thread(() -> fileLogger.log("Hello, world for file! From " + Thread.currentThread().getName()));
    Thread t6 = new Thread(() -> fileLogger.log("Hello, world for file! From " + Thread.currentThread().getName()));

    t4.start();
    t5.start();
    t6.start();

    t4.join();
    t5.join();
    t6.join();

    // 1. Create a larger pool of 20 threads
  //   Logger fileLogger = Logger.getFileLogger();
  //   ExecutorService executor = Executors.newFixedThreadPool(20);

  //   // 2. Submit 100 tasks, each writing to the file in rapid succession
  //   for (int i = 1; i <= 100; i++) {
  //       final int taskId = i;
  //       executor.submit(() -> {
  //           for (int j = 1; j <= 50; j++) {
  //               fileLogger.log("Task " + taskId + " - Log index " + j);
  //           }
  //       });
  //   }

  //   executor.shutdown();
  //   executor.awaitTermination(10, TimeUnit.SECONDS);
  // -------------------------------
  }
}
