package studyForJob;

/**
 * 多线程死锁问题
 * Created by ZXL on 2020/3/30.
 */
public class test2 {
    public static void main(String[] args) {
        DieLock d1 = new DieLock(true);
        DieLock d2 = new DieLock(false);
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
    }
}

class MyLock {
    public static Object o1 = new Object();
    public static Object o2 = new Object();
}

class DieLock implements Runnable {
    private boolean flag;
    DieLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (MyLock.o1) {
                    System.out.println(Thread.currentThread().getName() + " if o1");
                    synchronized (MyLock.o2) {
                        System.out.println(Thread.currentThread().getName() + " if o2");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (MyLock.o2) {
                    System.out.println(Thread.currentThread().getName() + " else o2");
                    synchronized (MyLock.o1) {
                        System.out.println(Thread.currentThread().getName() + " else o1");
                    }
                }
            }
        }
    }
}