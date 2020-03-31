package studyForJob;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ZXL on 2020/3/31.
 */
public class test4 {
    public static void main(String[] args) {
        int max = 10;
        LinkedBlockingQueue<Apple> queue = new LinkedBlockingQueue<>(max);

        producer p = new producer(queue, max);
        consumer c = new consumer(queue, max);

        p.start();
        c.start();
    }
}

class producer extends Thread {
    LinkedBlockingQueue queue;
    private int max;

    producer(LinkedBlockingQueue queue, int max) {
        this.queue = queue;
        this.max = max;
    }
    @Override
    public void run() {
        while (true) {
            try {
                queue.put(new Apple(queue.size()));
                System.out.println("produce:" + queue.size());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class consumer extends Thread {
    LinkedBlockingQueue queue;
    private int max;

    consumer(LinkedBlockingQueue queue, int max) {
        this.queue = queue;
        this.max = max;
    }
    @Override
    public void run() {
        while (true) {
            try {
                queue.take();
                System.out.println("consumer,left:" + queue.size());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Apple {
    private int id;
    Apple(int id) {
        this.id = id;
    }
}