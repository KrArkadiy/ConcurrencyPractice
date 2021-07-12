
import java.util.concurrent.CompletableFuture;

public class ConcurrencyPractice {
    public static void main(String[] args) {
        Foo f1 = new Foo();
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> f1.first(Thread.currentThread()));
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> f1.third(Thread.currentThread()));
        CompletableFuture<Void> voidCompletableFuture2 = CompletableFuture.runAsync(() -> f1.second(Thread.currentThread()));
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(voidCompletableFuture, voidCompletableFuture1, voidCompletableFuture2);
        System.out.println(allFutures);
    }
}

