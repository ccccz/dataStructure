package list;

public class Link<T> {
    public T data;
    Link<T> next;

    public Link(T info,Link<T> nextValue){
        data=info;
        this.next=nextValue;
    }

    public Link(Link<T> nextValue){
        this(null,nextValue);
    }
}
