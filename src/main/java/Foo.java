
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
}
