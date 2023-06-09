package syncronizedmethods;

public class Count {
    private int value;

    public synchronized void incrementCount(int i) {
        value += i;
    }

    public int getValue() {
        return value;
    }
}
