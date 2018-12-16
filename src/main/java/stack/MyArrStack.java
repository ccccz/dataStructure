package stack;

//基于数组的顺序栈
public class MyArrStack<T> {
    private int size;
    private int top;        //栈顶
    private T[] st;         //存放栈元素的数组

    public MyArrStack(int size){
        this.size=size;
        top=-1;
        st=(T[])new Object[size];
    }
    public MyArrStack(){
        this(1000);
    }

    public boolean push(T item){
        if (top==size-1){
            return false;
        }else{
            top++;
            st[top]=item;
            return true;
        }
    }

    public T pop(){
        if (top==-1){
            return null;
        }else{
            top--;
            return st[top+1];
        }
    }

    public boolean empty(){
        if (top==-1){
            return true;
        }else{
            return false;
        }
    }
}
