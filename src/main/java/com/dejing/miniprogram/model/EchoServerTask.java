package com.dejing.miniprogram.model;

public class EchoServerTask implements Runnable {
  @Override
  public void run() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(
        "This is a echo server. The current time is " + System.currentTimeMillis() + ".");
  }
}
