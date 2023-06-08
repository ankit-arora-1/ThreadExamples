package executors1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i = 1; i <= 100; i++) {
            if(i == 4 || i == 50) {
                System.out.println("Debug");
            }

            NumberPrinter numberPrinter = new NumberPrinter(i);
            executor.submit(numberPrinter);
        }

        executor.shutdown();
    }
}
