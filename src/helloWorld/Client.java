package helloWorld;

public class Client {
    public static void doSomething() {
        System.out.println("DoSomething. Printing from: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Hello world. Printing from: " + Thread.currentThread().getName());
        doSomething();
    }
}
