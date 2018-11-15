package stack;


//顺序队列
public class ArrQueue<T> extends Queue{
    private int size,front,rear;     //最大容量，队首，队尾
    private T[] qu;

    public ArrQueue(){
        this(10000);
    }
    public ArrQueue(int size){
        this.size=size;
        this.front=1;
        this.rear=0;
        qu=(T[])new Object[size];
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean enQueue(Object item) {
        if ((rear+2)%size==front){
            return false;
        }
        rear=(rear+1)%size;
        qu[rear]=(T)item;
        return true;
    }

    @Override
    public T deQueue() {
        if (this.isEmpty()){
            return null;
        }else{
            T result=qu[front];
            front=(front+1)%size;
            return result;
        }

    }

    @Override
    public T getFront() {
        if (this.isEmpty()){
            return null;
        }else{
            return qu[front];
        }
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
