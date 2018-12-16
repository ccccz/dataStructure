package stack;

public abstract class Queue<T> {
    public abstract void clear();
    public abstract boolean enQueue(T item);
    public abstract T deQueue();
    public abstract T getFront();
    public abstract boolean isEmpty();
    public abstract boolean isFull();
}
