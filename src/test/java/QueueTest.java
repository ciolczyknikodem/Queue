
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
        Integer expected = 0;

        assertEquals(expected, queue.dequeue());
    }

    @Test
    void isEmptyTest() {
        assertEquals(true, queue.isEmpty());
    }

    @Test
    void isQueueCorrectlyIncrementCapacity() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        int expected = 16;

        assertEquals(expected, queue.getQueueCapacity());
    }

    @Test
    void throwExceptionWhenTryDequeueEmptyContainer() {
        assertThrows(IndexOutOfBoundsException.class, queue::dequeue);
    }

}