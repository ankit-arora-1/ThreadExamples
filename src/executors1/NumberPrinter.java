package executors1;

public class NumberPrinter implements Runnable {
    private int num;
    public NumberPrinter(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Num = " + num + " Printing from: " + Thread.currentThread().getName());
    }
}
