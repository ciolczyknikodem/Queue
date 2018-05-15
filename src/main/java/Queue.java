public class Queue<T> implements QueueManager<T> {

    private T[] array;
    private int size = 2;
    private int queueSize = 0;

    @SuppressWarnings("unchecked")
    public Queue() {
        array = (T[]) new Object[size];
    }

    public void enqueue(T element) {
        queueSize++;
        ensureCapacity();

        array[queueSize - 1] = element;
    }

    public T peek() {
        return array[queueSize - 1];
    }

    public T dequeue() {
        queueSize--;
        return array[queueSize];
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (queueSize < size) {
            size = size * 2;
            T[] increasedArray = (T[]) new Object[size];
            rewriteElementsToMoreCapacityContainer(increasedArray);
        }
    }

    private void rewriteElementsToMoreCapacityContainer(T[] extendArray) {
        for (int i = 0; i < queueSize - 1; i++) {
            extendArray[i] = array[i];
        }
        array = extendArray;
    }

}