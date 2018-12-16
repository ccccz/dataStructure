package list;

public class LinkList<T> {
    private Link<T> head,tail;

    //找到并返回第p个元素的指针
    private Link<T> setPos(int p){
        if (p==-1){
            return head;
        }
        int count=0;
        Link<T> q=head.next;
        while(q!=null && count<p){
            q=q.next;
            count++;
        }
        return q;
    }

    //构造函数
    public LinkList(int s){

    }

    //判断链表是否为空
    public boolean isEmpty(){
        return true;
    }

    //清空
    public void clear(){

    }

    //返回实际长度
    public int length(){
        return 0;
    }

    //在表尾添加一个元素
    public boolean append(T value){
        return true;
    }

    //插入一个元素
    public boolean insert(int p,T value){
        Link<T> q=setPos(p-1);
        if (q==null){
            return false;
        }
        Link<T> temp=new Link<>(value,q.next);
        q.next=temp;
        if(q==tail){
            tail=temp;
        }
        return true;
    }

    //删除
    public boolean delete(int p){
        Link<T> q,temp;
        if((q=setPos(p-1))==null){
            return false;
        }
        temp=q.next;
                if (temp==tail){
            tail=q;
            q.next=null;
        }else{
            q.next=temp.next;
        }
        return true;
    }

    //返回位置p的元素值
    public boolean getValue(int p,T value){
        return true;
    }
    public boolean getValue(int p){
        return true;
    }

    //查找值为value的元素
    public boolean getPos(int p,T value){
        return true;
    }
    public boolean getPos(T value){
        return true;
    }

}
