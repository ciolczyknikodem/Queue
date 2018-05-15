public interface QueueManager<T> {

    void enqueue(T element);
    T peek();
    T dequeue();


}
