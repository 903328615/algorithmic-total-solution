import java.util.concurrent.CompletableFuture;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-08
 **/
public class Main2 {

    public static void main(String[] args) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        System.out.println(future.complete(null));
        System.out.println(future.complete(null));
        future.thenAccept((r)->{
            try {
                Thread.sleep(2000);
                System.out.println("dyinggq");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("the end");
    }

}

