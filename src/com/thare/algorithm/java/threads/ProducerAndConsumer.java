package com.thare.algorithm.java.threads;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}

class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    private Random random;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("producer is prepare");
        int number;
        while (true) {
            number = random.nextInt(10000);
            System.out.println("producer start to produce " + number);
            try {
                Thread.sleep(number);
                queue.put(number);
                System.out.println("producer successfully produce " + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    private Random random;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("consumer is prepare");
        int number;
        while (true) {
            try {
                number = queue.take();
                System.out.println("consumer prepare to consume " + number);
                Thread.sleep(number);
                System.out.println("consumer successfully consume " + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
