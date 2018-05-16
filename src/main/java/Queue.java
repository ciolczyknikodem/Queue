public class Queue<T> implements QueueManager<T> {

    private T[] array;
    private int capacity = 2;
    private int queueSize = 0;
    private int FIRST_ELEMENT_INDEX = 0;

    @SuppressWarnings("unchecked")
    public Queue() {
        array = (T[]) new Object[capacity];
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
        if (queueSize > 0) {
            return array[FIRST_ELEMENT_INDEX++];
        }
        throw new IndexOutOfBoundsException();
    }

    public int getQueueSize() {
        return queueSize;
    }

    public int getQueueCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (queueSize > capacity) {
            capacity = capacity * 2;
            T[] increasedArray = (T[]) new Object[capacity];
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