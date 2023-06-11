package producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    Queue<Object> queue;
    int maxSize;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    public Producer(Queue queue, int maxSize, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                    System.out.println("Adding. Queue size: " + queue.size());
                    queue.add(new Object());

                consumerSemaphore.release();
        }
    }
}
