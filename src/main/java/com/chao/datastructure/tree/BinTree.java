package com.chao.datastructure.tree;

/**
 * Created by machao on 2018/4/19.
 */
public class BinTree {
    private final static Integer MAX = 40;
    //数据元素
    private Object data;
    //指向左节点
    private BinTree left;
    //指向右节点
    private BinTree right;
    //层序遍历时指向各个节点
    BinTree[] elements = new BinTree[MAX];
    //层序遍历头
    int front;
    //层序遍历尾部
    int rear;

    public BinTree() {
    }

    public BinTree(Object data) {
        this.data = data;
        left = right = null;
    }

    public BinTree(Object data, BinTree left, BinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinTree{" +
                "data=" + data +
                '}';
    }

    //前序遍历
    public static void preOrder(BinTree parent){
        if (parent == null) return;

        System.out.println(parent.data + "");
        preOrder(parent.left);
        preOrder(parent.right);
    }

    //中序遍历
    public static void inOrder(BinTree parent){
        if (parent == null) return;

        inOrder(parent.left);
        System.out.println(parent.data + "");
        inOrder(parent.right);
    }

    //后序遍历
    public static void postOrder(BinTree parent){
        if (parent == null) return;

        inOrder(parent.left);
        inOrder(parent.right);
        System.out.println(parent.data + "");
    }

    //层次遍历二叉树
    public void LayerOrder(BinTree parent){
        elements[0] = parent;
        front = 0;
        rear = 1;

        while (front < rear){
            try {
                if (elements[front].data != null){
                    System.out.println(elements[front].data + "");
                    if (elements[front].left != null)
                        elements[rear ++] = elements[front].left;
                    if (elements[front].right != null)
                        elements[rear ++] = elements[front].right;
                    front ++;
                }

            }catch (Exception e){
                e.printStackTrace();
                break;
            }
        }
    }

    //返回树的叶子节点的个数
    public int leaves(){
        if (this == null)
            return 0;
        if (left == null && right == null)
            return 1;
        return (left == null ? 0 : left.leaves())
                + (right == null ? 0 : right.leaves());
    }

    //结果返回树的高度
    public int height(){
        int heightOfTree;
        if (this == null)
            return -1;

        int leftHeight = (left == null ? 0 : left.height());
        int rightHeight = (right == null ? 0 : right.height());
        heightOfTree = leftHeight < rightHeight ? rightHeight : leftHeight;

        return 1+heightOfTree;

    }
    //查找对象所处树中层次，如果不在树中放回 -1
    public int level(Object object){
        int levelInTree;
        if (this == null)
            return -1;
        if (object == data)
            return 1;
        int leftLevel = (left == null ? -1 : left.level(object));
        int rightLevel = (right == null ? -1 : right.level(object));
        if (leftLevel < 0 && rightLevel < 0)
            return -1;
        levelInTree = leftLevel < rightLevel ? rightLevel : leftLevel;
        return 1 + levelInTree;
    }

    //将树中的每个节点的孩子兑换位置
    public void reflect(){
        if (this == null)
            return;
        if (left != null)
            left.reflect();
        if (right != null)
            right.reflect();
        BinTree temp = left;
        left = right;
        right = temp;
    }

    //将树中的所有节点移走，并输出移走的节点
    public void defoliate(){
        String innerNode ="";
        if (this == null)
            return;
        //若本节点是叶子节点，则将其移走
        if (left == null && right == null){
            System.out.println(this + "");
            data = null;
            return;
        }
        //移走左子树若其存在
        if (left != null){
            left.reflect();
            left = null;
        }

        //移走本节点，放在中间表示中跟移走
        innerNode += this + "";
        data = null;

        //移走右子树若其存在
        if (right != null){
            right.reflect();
            right = null;
        }

    }


}
