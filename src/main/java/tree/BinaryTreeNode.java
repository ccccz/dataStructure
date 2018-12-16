package tree;

public class BinaryTreeNode<T> {
    public T info;
    public BinaryTreeNode<T> leftchild,rightchild;
    public BinaryTreeNode(){
        this(null);
    }
    public BinaryTreeNode(T info){
        this(info,null,null);
    }
    public BinaryTreeNode(T info,BinaryTreeNode<T> l,BinaryTreeNode<T> r){
        this.info=info;
        this.leftchild=l;
        this.rightchild=r;
    }

    public void setLeftchild(BinaryTreeNode<T> leftchild){
        this.leftchild=leftchild;
    }

    public void setRightchild(BinaryTreeNode<T> rightchild){
        this.rightchild=rightchild;
    }

    public void setInfo(T value){
        info=value;
    }

    //判断是否为叶结点
    public boolean ifLeaf(){
        if (leftchild==null && rightchild==null){
            return true;
        }
        return false;
    }
}
