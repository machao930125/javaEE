package com.chao.datastructure.tree;

public class MulTreeTest {

    /**
     * 计算多路树的节点个数
     *
     * @param head
     * @return
     */
    public static int calcCount(MulTree head) {
        if (head == null) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < head.tree.size(); i++) {
            result += calcCount(head.tree.get(i));
        }
        return result;
    }


    public static void main(String[] args) {
        MulTree mulTree1 = new MulTree(1);
        MulTree mulTree2 = new MulTree(2);
        MulTree mulTree3 = new MulTree(3);
        MulTree mulTree4 = new MulTree(4);
        MulTree mulTree5 = new MulTree(5);
        MulTree mulTree6 = new MulTree(6);
        MulTree mulTree7 = new MulTree(7);
        MulTree mulTree8 = new MulTree(7);

        mulTree1.tree.add(mulTree2);
        mulTree1.tree.add(mulTree3);
        mulTree1.tree.add(mulTree4);
        mulTree2.tree.add(mulTree5);
        mulTree2.tree.add(mulTree6);
        mulTree2.tree.add(mulTree7);
        mulTree7.tree.add(mulTree8);


        System.out.println(calcCount(mulTree1));
    }
}
