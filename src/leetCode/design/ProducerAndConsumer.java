package leetCode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者消费者
 * Created by ZXL on 2019/9/19.
 */
public class ProducerAndConsumer {
    private int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<>();

    // 生产者
    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) {
                        queue.notify();
                        System.out.println("队列满");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    try {
                        Thread.sleep(500);
                        System.out.println("生产加一，队列数"+queue.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        queue.notify();
                        System.out.println("队列空");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    try {
                        Thread.sleep(500);
                        System.out.println("消费减一，队列数"+queue.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer pc = new ProducerAndConsumer();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}
