package com.dsalgado.examples.threads;

public class MyCustomThreadRunnable implements Runnable {
  private Thread thread;

  public MyCustomThreadRunnable(String threadName) {
    thread = new Thread(this, threadName);
    System.out.println("New thread: " + thread);
    thread.start();
  }

  @Override
  public void run() {
    try {
      for (int i = 5; i > 0; i--) {
        System.out.println("TNew thread: " + i);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out.println("Sleep throws exception: " + e.getStackTrace());
    }
    System.out.println("End of " + thread);
  }
}
