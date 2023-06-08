package helloWorldThreads;

public class Client {
    public static void main(String[] args) {
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread t1 = new Thread(helloWorldPrinter);
        t1.start();

        System.out.println("Hello world. Printing from: " + Thread.currentThread().getName());
    }
}
