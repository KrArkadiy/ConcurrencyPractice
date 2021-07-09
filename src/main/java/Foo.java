import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

//Общий ресурс
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
}

class Main {
    public static void main(String[] args) throws InterruptedException {

        Foo f1 = new Foo();
        MySecondThread mST = new MySecondThread(f1, "B");
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

    public void run(){
        f1.third(this);
    }
}




