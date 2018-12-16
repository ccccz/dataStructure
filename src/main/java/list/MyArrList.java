package list;

//顺序表
public class MyArrList<T> {
    private T[] aList;
    private int maxSize;
    private int curLen;   //链表长度
    private int position;  //当前元素位置

    //构造函数
    public MyArrList(int size){
        maxSize=size;
        aList=(T[])new Object[maxSize];
        curLen=0;
        position=0;
    }

    //清除
    public void clear(){
        aList=null;
        curLen=0;
        position=0;
        aList=(T[])new Object[maxSize];
    }

    //长度
    public int length(){
        return curLen;
    }

    //在表尾添加元素
    public boolean append(T value){
        if (curLen==maxSize){
            return false;
        }
        aList[curLen]=value;
        curLen++;
        return true;

        //为什么会有失败情况
    }

    //指定位置插入
    public boolean insert(int p,T value){
        if (curLen>=maxSize){
            return false;
        }else if(p<0 || p>curLen){
            return false;
        }
        for (int i=curLen;i>p;i--){
            aList[i]=aList[i-1];
        }
        aList[p]=value;
        curLen++;
        return true;
    }

    //删除
    public boolean dalete(int p){
        if (p<0 || p>curLen-1){
            return false;
        }
        for (int i=p;i<curLen-1;i++){
            aList[i]=aList[i+1];
        }
        aList[curLen]=null;
        curLen--;
        return true;
    }

    //设置元素
    public boolean setValue(int p,T value){
        return true;
    }

    //返回元素
    public boolean getValue(int p){
        return true;
    }

    //查找
    public boolean getPos(int p,T value){
        return true;
    }
}
