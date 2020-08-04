package com.jucdemo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description: 阻塞队列的测试demo
 * @author: cfireworks
 * @create: 2020-08-04 22:07
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(100, false);
        Thread thread1 = new Thread(() -> {
            try {
                while(true){
                    blockingQueue.add(1);
                    System.out.println("add");
                    Thread.sleep(1);
                }
            } catch (Exception e) {
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                while(true){
                    Thread.sleep(1);
                    blockingQueue.remove();
                    System.out.println("remove");
                }
            } catch (Exception e) {
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(1000L);
        return;
    }
}
