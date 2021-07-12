
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConcurrencyPractice {
    public static void main(String[] args) {
        Foo f1 = new Foo();
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> f1.first(Thread.currentThread()));
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e);
        }
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> f1.third(Thread.currentThread()));
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e);
        }
        CompletableFuture<Void> voidCompletableFuture2 = CompletableFuture.runAsync(() -> f1.second(Thread.currentThread()));
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}

