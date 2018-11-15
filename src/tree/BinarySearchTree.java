package tree;

import java.util.Comparator;

/**
 * BST二叉查找树
 */
public class BinarySearchTree<T> {

    public static void main(String[] args){
    }

    private BinaryTreeNode<T> root;    //根是私有的，外部不能引用
    private Comparator<? super T> cmp;   //如果不要求这些项是可比较的时使用
    public BinarySearchTree(){
        root=null;
    }

    public void makeEmpty(){
        root=null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public boolean contains(T x){
        return this.contains(x,root);
    }

    public T findMin(){
        if (isEmpty())
            return null;
        return this.findMin(root).info;
    }

    public T findMax(){
        if (isEmpty())
            return null;
        return this.findMax(root).info;
    }

    public void insert(T x){
        root=insert(x,root);
    }

    public void remove(T x){
        root=this.remove(x,root);
    }

    public void printTree(){

    }

    //私有方法
    private boolean contains(T x,BinaryTreeNode<T> node){
        //空树
        if (node==null){
            return false;
        }
        //比较
        int  compareResult=myCompare(x,node.info);
        if (compareResult<0){
            return contains(x,node.leftchild);
        }else if(compareResult>0){
            return contains(x,node.rightchild);
        }
        return true;
    }
    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> node){
        if (node==null)
            return null;
        if (node.leftchild==null){
            return node;
        }else{
            return findMin(node.leftchild);
        }
    }
    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> node){
        if (node==null)
            return null;
        if (node.rightchild==null){
            return node;
        }else{
            return findMax(node.rightchild);
        }
    }

    private BinaryTreeNode<T> insert(T x,BinaryTreeNode<T> node){
        if (node==null){
            node=new BinaryTreeNode<>(x);
            return node;
        }

        //大抵是对树进行插入后重新赋值，返回插入后的树
        int  compareResult=myCompare(x,node.info);
        if (compareResult<0){
            node.leftchild=insert(x,node.leftchild);
        }else if(compareResult>0){
            node.rightchild=insert(x,node.rightchild);
        }
        return node;
    }

    private BinaryTreeNode<T> remove(T x,BinaryTreeNode<T> node){
        if (node==null){
            return null;
        }
        int compareResult=cmp.compare(x,node.info);

        if(compareResult<0){
            node.leftchild=remove(x,node.leftchild);
        }else if (compareResult>0){
            node.rightchild=remove(x,node.rightchild);
        }else if(node.leftchild!=null && node.rightchild!=null){
            //同时拥有左右子女
            node.info=findMin(node.rightchild).info;
            node.rightchild=remove(node.info,node.rightchild);
        }else{
            node=(node.leftchild==null) ? node.rightchild : node.leftchild;
        }
        return node;
    }

    private void printTree(BinaryTreeNode<T> node){
    }

    //关于T的比较方法
    private int myCompare(T l,T r){
        if (cmp!=null){
            return cmp.compare(l,r);
        }else{
            return ((Comparable)l).compareTo(r);
        }
    }
}
