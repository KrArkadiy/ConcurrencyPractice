
import java.util.concurrent.*;

public class Foo {

    static Semaphore semaphore = new Semaphore(1);
    static Semaphore semaphore1 = new Semaphore(0);
    static Semaphore semaphore2 = new Semaphore(0);

    public void first(Runnable r) {
        try {
            semaphore.acquire();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.print("first");
        semaphore1.release();
    }

    public void second(Runnable r) {
        try {
            semaphore1.acquire();
        } catch (InterruptedException exc){
            System.out.println(exc);
        }
        System.out.print("second");
        semaphore2.release();
    }

    public void third(Runnable r) {
        try{
            semaphore2.acquire();
        } catch (InterruptedException exc){
            System.out.println(exc);
        }
        System.out.print("third");
        semaphore2.release();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Foo f1 = new Foo();

        new MySecondThread(f1, "B");
        new MyFirstThread(f1, "A");
        new MyThirdThread(f1, "C");
    }
}

class MyFirstThread implements Runnable {
    String name;
    Foo f1;

    public MyFirstThread(Foo f, String n) {
        name = n;
        f1 = f;
        new Thread(this).start();
    }

    public void run() {
        f1.first(this);
    }
}

class MySecondThread implements Runnable {
    String name;
    Foo f1;

    public MySecondThread(Foo f, String n) {
        name = n;
        f1 = f;
        new Thread(this).start();
    }

    public void run() {
       f1.second(this);
    }
}

class MyThirdThread implements Runnable {
    String name;
    Foo f1;


    public MyThirdThread(Foo f, String n) {
        name = n;
        f1 = f;
        new Thread(this).start();
    }

    public void run() {
       f1.third(this);
    }
}
