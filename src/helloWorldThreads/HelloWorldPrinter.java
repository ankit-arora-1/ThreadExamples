package helloWorldThreads;

public class HelloWorldPrinter implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World. Printing from: " + Thread.currentThread().getName());
    }
}
