package com.chao.leetcode;

import com.chao.datastructure.linked.LinkedNode;

/**
 * 问题：
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author chao
 */
public class LeetCode0021 {

    /**
     * 采用递归的方式合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static LinkedNode mergeTwoLinkedNode(LinkedNode<Integer> l1, LinkedNode<Integer> l2) {
        // 处理两个边界情况，l1为null或者l2为null
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 按照数据大小进行链表合并
        if (l1.getData() < l2.getData()) {
            LinkedNode linkedNode = mergeTwoLinkedNode(l1.getNext(), l2);
            l1.setNext(linkedNode);
            return l1;
        } else {
            LinkedNode linkedNode = mergeTwoLinkedNode(l1, l2.getNext());
            l2.setNext(linkedNode);
            return l2;
        }
    }

    /**
     * 测试
     */
    static class Test {

        public static void main(String[] args) {
            LinkedNode l1 = initSingleLinked1();
            LinkedNode l2 = initSingleLinked2();
            LinkedNode linkedNode = mergeTwoLinkedNode(l1, l2);
            linkedNode.display();
        }

        /**
         * 初始化单链表
         *
         * @return
         */
        public static LinkedNode initSingleLinked1() {
            LinkedNode head = new LinkedNode(0);
            LinkedNode linkedNode1 = new LinkedNode(3);
            LinkedNode linkedNode2 = new LinkedNode(6);
            LinkedNode linkedNode3 = new LinkedNode(8);
            head.setNext(linkedNode1);
            linkedNode1.setNext(linkedNode2);
            linkedNode2.setNext(linkedNode3);
            return head;
        }

        /**
         * 初始化单链表
         *
         * @return
         */
        public static LinkedNode initSingleLinked2() {
            LinkedNode head = new LinkedNode(0);
            LinkedNode linkedNode1 = new LinkedNode(1);
            LinkedNode linkedNode2 = new LinkedNode(6);
            LinkedNode linkedNode3 = new LinkedNode(7);
            head.setNext(linkedNode1);
            linkedNode1.setNext(linkedNode2);
            linkedNode2.setNext(linkedNode3);
            return head;
        }

    }
}
