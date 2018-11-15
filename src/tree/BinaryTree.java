package tree;

import stack.*;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree(){
        root=null;
    }

    //判断是否为空树
    public boolean isEmpty(){
        return true;
    }

    //返回根结点
    public BinaryTreeNode<T> Root(){
        return root;
    }

    //返回父节点
    public BinaryTreeNode<T> Parent(BinaryTreeNode<T> root,BinaryTreeNode<T> current){
        BinaryTreeNode<T> tmp;
        if (root==null){
            return null;
        }
        if (current==root.leftchild || current==root.rightchild){
            return root;     //如果孩子是current则返回parent
        }
        //递归
        if ((tmp=Parent(root.leftchild,current))!=null){
            return tmp;
        }
        if ((tmp=Parent(root.rightchild,current))!=null){
            return tmp;
        }
        return null;
    }

    //返回左兄弟
    public BinaryTreeNode<T> LeftSibling(){
        return null;
    }

    //返回右兄弟
    public BinaryTreeNode<T> RightSibling(){
        return null;
    }

    //构造新树
    public void CreateTree(T info,BinaryTree<T> leftTree,BinaryTree<T> rightTree){

    }

    //前序遍历
    public void PreOrder(BinaryTreeNode<T> node){
        if(node!=null){
            System.out.print(node.info);
            PreOrder(node.leftchild);
            PreOrder(node.rightchild);
        }
    }
    //非递归的前序遍历
    public void PreOrderNo(BinaryTreeNode<T> node){
        MyArrStack<BinaryTreeNode> aStack=new MyArrStack<>();
        BinaryTreeNode<T> pointer=node;
        aStack.push(null);
        while(pointer!=null){
            System.out.print(pointer.info);
            if (pointer.rightchild!=null){
                aStack.push(pointer.rightchild);
            }
            if (pointer.leftchild!=null){
                pointer=pointer.leftchild;
            }else{
                pointer=aStack.pop();
            }
        }
    }

    //中序遍历
    public void InOrder(BinaryTreeNode<T> node){
        if (node!=null){
            InOrder(node.leftchild);
            System.out.print(node.info);
            InOrder(node.rightchild);
        }
    }
    //非递归的中序遍历
    public void InOrderNo(BinaryTreeNode<T> node) {
        MyArrStack<BinaryTreeNode> aStack=new MyArrStack<>();
        BinaryTreeNode<T> pointer=node;
        while(!aStack.empty() || pointer!=null){
            if (pointer!=null){
                aStack.push(pointer);
                pointer=pointer.leftchild;
            }else{
                pointer=aStack.pop();
                System.out.print(pointer);
                pointer=pointer.rightchild;
            }
        }
    }


    //后序遍历
    public void PostOrder(BinaryTreeNode<T> node){
        if (node!=null){
            PostOrder(node.leftchild);
            PostOrder(node.rightchild);
            System.out.print(node.info);
        }
    }
    //非递归的后序遍历
    public void PostOrderNo(BinaryTreeNode<T> node){
        BinaryTreeNode<T> pointer=node;
        MyArrStack<StackElement> aStack=new MyArrStack<>();
        StackElement<BinaryTreeNode> element=new StackElement<>();
        while(!aStack.empty() || pointer!=null){
            while(pointer!=null){
                element.pointer=pointer;
                element.tag=Tag.Left;
                aStack.push(element);
                pointer=pointer.leftchild;
            }
            element=aStack.pop();
            pointer=element.pointer;
            if (element.tag==Tag.Left){
                element.tag=Tag.Right;
                aStack.push(element);
            }else{
                System.out.print(pointer.info);
                pointer=null;
            }
        }
    }

    //按层次遍历
    public void LevelOrder(BinaryTreeNode<T> node){
        ArrQueue<BinaryTreeNode> aQueue=new ArrQueue<BinaryTreeNode>();
        BinaryTreeNode<T> pointer=node;
        if (pointer!=null){              //保存根节点
            aQueue.enQueue(pointer);
        }
        while(!aQueue.isEmpty()){
            pointer=aQueue.deQueue();    //取队列的队首元素
            System.out.println(pointer.info);
            if (pointer.leftchild!=null){    //将此元素的子女存入队列
                aQueue.enQueue(pointer.leftchild);
            }
            if (pointer.rightchild!=null){
                aQueue.enQueue(pointer.rightchild);
            }

        }
    }

    //删除
    public void DeleteBinaryTree(BinaryTreeNode<T> node){

    }
}
