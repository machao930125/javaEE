package com.chao.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 1、查找一个节点的后继节点、前驱节点
 * 2、获取二叉树的最大宽度
 * 3、判断二叉树是否是平衡二叉树
 * 4、判断二叉树是否是搜索二叉树
 * 5、返回二叉搜索树的最大节点数
 * 6、查找二叉树某节点的后继节点
 */
public class TreeTest {

    public static void main(String[] args) {
        Tree tree = initTree();
        printPre(tree);
        System.out.println();
        printIn(tree);
        System.out.println();
        printAfter(tree);
        System.out.println();
        printLevel(tree);
        System.out.println();
        int i = maxWeighNoMap(tree);
        System.out.println(i);
        System.out.println(isBalance(tree));
        System.out.println(isBinSearch(tree));
        Tree searchTree = initSearchTree();
        System.out.println(isBalance(searchTree));
        System.out.println(isBinSearch(searchTree));
        System.out.println(maxCount(searchTree));
        System.out.println(findAftNode(searchTree.right).value);

    }

    public static Tree findAftNode(Tree node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return node.right;
        }

        while (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }


    static class SearchInfo {
        boolean search;
        int min;
        int max;
        int maxCount;

        public SearchInfo(boolean search, int min, int max) {
            this.search = search;
            this.min = min;
            this.max = max;
        }

        public SearchInfo(boolean search, int min, int max, int maxCount) {
            this.search = search;
            this.min = min;
            this.max = max;
            this.maxCount = maxCount;
        }

        @Override
        public String toString() {
            return "SearchInfo{" +
                    "search=" + search +
                    ", min=" + min +
                    ", max=" + max +
                    ", maxCount=" + maxCount +
                    '}';
        }
    }

    /**
     * 获取最大节点数
     *
     * @param tree
     * @return
     */
    public static int maxCount(Tree tree) {
        return findMax(tree).maxCount;
    }

    public static SearchInfo findMax(Tree tree) {
        if (tree == null) {
            return null;
        }
        SearchInfo leftMax = findMax(tree.left);
        SearchInfo rightMax = findMax(tree.right);

        int min = tree.value;
        int max = tree.value;
        if (leftMax != null) {
            max = Math.max(max, leftMax.max);
            min = Math.min(min, leftMax.min);
        }
        if (rightMax != null) {
            max = Math.max(max, rightMax.max);
            min = Math.min(min, rightMax.min);
        }
        int maxCount = 0;
        if (leftMax != null) {
            maxCount = leftMax.maxCount;
        }
        if (rightMax != null) {
            maxCount = Math.max(maxCount, rightMax.maxCount);
        }
        boolean search = false;
        if ((leftMax == null ? true : leftMax.search)
                && (rightMax == null ? true : rightMax.search)
                && (leftMax == null ? true : leftMax.max < tree.value)
                && (rightMax == null ? true : rightMax.min > tree.value)) {
            search = true;
            maxCount = (leftMax == null ? 0 : leftMax.maxCount) +
                    (rightMax == null ? 0 : rightMax.maxCount) + 1;
        }

        return new SearchInfo(search, min, max, maxCount);

    }

    /**
     * 是否是二叉搜索树
     *
     * @param node
     * @return
     */
    public static SearchInfo isBinSearch(Tree node) {
        if (node == null) {
            return null;
        }
        SearchInfo left = isBinSearch(node.left);
        SearchInfo right = isBinSearch(node.right);

        boolean result = false;
        if ((left == null ? true : left.search)
                && (right == null ? true : right.search)
                && (left == null ? true : left.max < node.value)
                && (right == null ? true : right.min > node.value)) {
            result = true;
        }
        int min = node.value;
        int max = node.value;
        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }
        return new SearchInfo(result, min, max);
    }

    static class Info {
        boolean balance;
        int height;

        public Info(boolean balance, int height) {
            this.balance = balance;
            this.height = height;
        }
    }

    public static boolean isBalance(Tree parent) {
        Info process = process(parent);
        return process.balance;
    }

    public static Info process(Tree node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftProcess = process(node.left);
        Info rightProcess = process(node.right);

        int height = Math.max(leftProcess.height, rightProcess.height) + 1;
        boolean result = true;
        if (!leftProcess.balance || !rightProcess.balance || leftProcess.height - rightProcess.height > 1) {
            result = false;
        }
        return new Info(result, height);

    }

//    public static Tree findAfterTree(Tree node){
//        Tree temp = node;
//        while (node != null){
//            node = node.parent;
//        }
//
//    }
//    public static Tree findAfterTree(Tree node,Tree target){
//        if (node.value == target.value){
//            return
//        }
//    }

    /**
     * 获取二叉树的最大宽度
     *
     * @param parent
     * @return
     */
    public static int maxWeightWithMap(Tree parent) {
        return 0;
    }

    public static int maxWeighNoMap(Tree parent) {
        if (parent == null) {
            return 0;
        }
        Deque<Tree> queue = new ArrayDeque<>();
        queue.add(parent);

        Tree curEnd = parent;
        Tree nextEnd = null;
        int max = 0;
        int levelNodes = 0;

        while (!queue.isEmpty()) {
            Tree cur = queue.poll();
            levelNodes++;
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }

            if (cur == curEnd) {
                max = Math.max(max, levelNodes);
                levelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;

    }

    /**
     * 层序遍历，借用队列，先进先出
     *
     * @param parent
     */
    public static void printLevel(Tree parent) {
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(parent);
        while (!queue.isEmpty()) {
            Tree cur = queue.poll();
            System.out.print(cur.value + ",");

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    /**
     * 先序遍历
     *
     * @param parent
     */
    public static void printPre(Tree parent) {
        if (parent == null) {
            return;
        }
        System.out.print(parent.value + ",");
        printPre(parent.left);
        printPre(parent.right);
    }

    public static void printIn(Tree parent) {
        if (parent == null) {
            return;
        }
        printIn(parent.left);
        System.out.print(parent.value + ",");
        printIn(parent.right);
    }

    public static void printAfter(Tree parent) {
        if (parent == null) {
            return;
        }
        printAfter(parent.left);
        printAfter(parent.right);
        System.out.print(parent.value + ",");
    }

    /**
     * 初始化一颗满二叉树
     *
     * @return
     */
    public static Tree initTree() {
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);
        Tree tree8 = new Tree(8);
        Tree tree9 = new Tree(9);
        Tree tree10 = new Tree(10);
        Tree tree11 = new Tree(11);

        tree1.left = tree2;
        tree2.parent = tree1;
        tree1.right = tree3;
        tree3.parent = tree2;
        tree2.left = tree4;
        tree4.parent = tree2;
        tree2.right = tree5;
        tree5.parent = tree2;
        tree3.left = tree6;
        tree6.parent = tree3;
        tree3.right = tree7;
        tree7.parent = tree3;
        tree4.left = tree8;
        tree8.parent = tree4;
        tree4.right = tree9;
        tree9.parent = tree4;
        tree5.left = tree10;
        tree10.parent = tree5;
        tree10.right = tree11;

        return tree1;
    }

    public static Tree initSearchTree() {
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);
        Tree tree8 = new Tree(8);

        tree4.left = tree2;
        tree4.right = tree6;
        tree2.left = tree1;
        tree2.right = tree3;
        tree6.left = tree5;
        tree6.right = tree8;
//        tree8.right = tree7;
        return tree4;
    }
}
