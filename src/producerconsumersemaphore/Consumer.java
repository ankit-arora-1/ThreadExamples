package producerconsumersemaphore;

import com.sun.xml.internal.ws.resources.SenderMessages;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    Queue<Object> queue;
    int maxSize;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    public Consumer(Queue queue, int maxSize, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }
    @Override
    public void run() {
        while(true) {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.out.println("Removing. Queue size: " + queue.size());
                queue.remove();

            producerSemaphore.release();
        }
    }
}
