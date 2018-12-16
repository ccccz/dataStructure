package stack;

public class MyLinkStack<T> {
    private Link<T> top;
    private int size;

    public MyLinkStack(){
        top=null;
        this.size=0;
    }

    public boolean push(T item){
        Link<T> tmp=new Link<>(item,top);
        top=tmp;
        size++;
        return true;
    }

    public T pop(){
        Link<T> tmp;
        if (size==0){
            return null;
        }else{
            tmp=top;
            top=tmp.next;
            top.next=null;
            size--;
            return tmp.data;
        }
    }
}
