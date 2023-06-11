package producerconsumerintro;

import java.util.Queue;

public class Consumer implements Runnable {
    Queue<Object> queue;
    int maxSize;

    public Consumer(Queue queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (queue) {
                if (queue.size() > 0) {
                    System.out.println("Removing. Queue size: " + queue.size());
                    queue.remove();
                }
            }
        }
    }
}
