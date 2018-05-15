
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<Integer> queue;
    
    @BeforeEach
    void prepareEnvironment() {
        queue = new Queue<>();
    }

    @Test
    void constructorTest() {
        Queue<Integer> queue = new Queue<>();
    }

    @Test
    void enqueueTest() {
        queue.enqueue(5);
    }

    @Test
    void peekTest() {
        queue.enqueue(10);
        Integer expected = 10;

        assertEquals(expected, queue.peek());
    }

    @Test
    void queueSizeTest() {
        queue.enqueue(10);

        assertEquals(1, queue.getQueueSize());
    }

    @Test
    void dequeueTest() {
        for (int i = 0; i < 3; i++) {
            queue.enqueue(i);
        }
        Integer expected = 2;

        assertEquals(expected, queue.dequeue());
    }

    @Test
    void isEmptyTest() {
        assertEquals(true, queue.isEmpty());
    }

}