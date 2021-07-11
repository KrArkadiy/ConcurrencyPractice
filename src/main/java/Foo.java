
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Foo {

    public void first(Runnable r) {
        System.out.print("first");
    }

    public void second(Runnable r) {
        System.out.print("second");
    }

    public void third(Runnable r) {
        System.out.print("third");
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        Foo f1 = new Foo();

        MySecondThread mST = new MySecondThread(f1, cb, "B");
        MyThirdThread mTT = new MyThirdThread(f1, cb, "A");
        MyFirstThread mFT = new MyFirstThread(f1, cb, "C");
    }
}

class MyFirstThread implements Runnable {
    String name;
    Foo f1;
    CyclicBarrier cyclicBarrier;

    public MyFirstThread(Foo f, CyclicBarrier cb, String n) {
        cyclicBarrier = cb;
        name = n;
        f1 = f;
        new Thread(this).start();
    }

    public void run() {
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}

class MySecondThread implements Runnable {
    String name;
    Foo f1;
    CyclicBarrier cyclicBarrier;

    public MySecondThread(Foo f, CyclicBarrier cb, String n) {
        cyclicBarrier = cb;
        name = n;
        f1 = f;
        new Thread(this).start();
    }

    public void run() {
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}

class MyThirdThread implements Runnable {
    String name;
    Foo f1;
    CyclicBarrier cyclicBarrier;

    public MyThirdThread(Foo f, CyclicBarrier cb, String n) {
        cyclicBarrier = cb;
        name = n;
        f1 = f;
        new Thread(this).start();
    }

    public void run() {
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}

class BarAction implements Runnable {

    Foo f1 = new Foo();
    public void run() {
        System.out.println("Барьер достигнут");
        System.out.println();
        f1.first(this);
        f1.second(this);
        f1.third(this);
    }
}

