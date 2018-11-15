package stack;

public class LinkQueue<T> extends Queue{

    private int size=0;
    Link<T> front;
    Link<T> rear;

    @Override
    public void clear() {

    }

    @Override
    public boolean enQueue(Object item) {
        if (rear==null){
            front=new Link<T>((T)item,null);
            rear=front;
        }else{
            rear.next=new Link<T>((T)item,null);
            rear=rear.next;
        }
        size++;
        return true;
    }

    @Override
    public T deQueue() {
        if (isEmpty()){
            return null;
        }
        T result=front.data;
        front=front.next;
        size--;
        return result;
    }

    @Override
    public Object getFront() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
