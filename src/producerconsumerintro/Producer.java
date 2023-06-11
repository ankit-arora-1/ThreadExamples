package producerconsumerintro;

import java.util.Queue;

public class Producer implements Runnable {
    Queue<Object> queue;
    int maxSize;

    public Producer(Queue queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (queue) {
                if (queue.size() < maxSize) {
                    System.out.println("Adding. Queue size: " + queue.size());
                    queue.add(new Object());
                }
            }
        }
    }
}
