package com.dsalgado.examples.threads;

public class MyCustomThreadInheritance extends Thread {

  public MyCustomThreadInheritance(String threadName) {
    super(threadName);
    System.out.println("New thread: " + this);
    start();
  }

  public void run() {
    // code
  }
}
