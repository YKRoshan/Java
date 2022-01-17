package com.Java8Features.LamdaExpression;

public class MyThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println("Name1: " + Thread.currentThread().getName());//Name1: main
        Thread myThread = new Thread(runnable);
        System.out.println("Name2: " + myThread.getName());//Name2: Thread-0
        myThread.setName("MyThread");
        myThread.start();
    }
}
