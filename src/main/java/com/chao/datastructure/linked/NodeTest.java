package com.chao.datastructure.linked;

import java.util.HashMap;

public class NodeTest {

//    public Node reverseGroup(Node head, int group) {
//        Stack<Node> stack = new ArrayStack<>();
//        Node cur = head;
//        while (cur != null) {
//            if (stack.count() < group) {
//                stack.push(cur);
//                cur = cur.next;
//            } else {
//                while (!stack.isEmpty()) {
//                    Node pop = stack.pop();
//                }
//            }
//        }
//    }


    public Node mergeLink(Node head1, Node head2) {
        Node first = new Node();

        Node cur = first;

        while (head1 != null && head2 != null) {
            if (head1.value >= head2.value) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;

        return first.next;
    }

    // 遍历解法
// 同时不断遍历两个链表，取出小的追加到新的头节点后，直至两者其中一个为空
// 再将另一者追加的新链表最后
    public Node mergeTwoLists(Node l1, Node l2) {

        Node dummy = new Node();

        Node curNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        curNode.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    // 递归解法
    // 递归的核心方法是将问题规模不断缩小化
    // 合并两个长度为n和m的链表，在value(n) < value(m)可以将规模缩减为合并长度为(n-1)和m的链表
    public Node mergeTwoLists2(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.value < l2.value) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    public Node reverseKGroup(Node head, int k) {
        if (head == null) return null;
        Node cur = head;
        int i = k;
        // 先遍历找到下一段的开头
        while (i > 0 && cur != null) {
            cur = cur.next;
            i--;
        }
        // 如果没有到k个，那么原顺序返回
        if (i > 0) return head;
        // 关键在于这个位置，返回值拼接到当前段翻转后的尾结点即可
        // 而尾结点就是原链表在当前段的头
        Node pre = reverseKGroup(cur, k);
        cur = head;
        i = k;
        while (i > 0) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            i--;
        }
        return pre;
    }


    public Node reverse(Node head) {
        if (null == head || head.next == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        Node temp;
        while (cur != null) {
            temp = cur.next;
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }

    public boolean findCircle(Node head) {
        Node fastPoint = head;
        Node slowPoint = head;
        while (fastPoint != null && fastPoint.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;

            if (slowPoint == fastPoint) {
                return true;
            }
        }
        return false;
    }

    public boolean delNode(Node head, int num) {
        int point = 1;
        Node pre = head;
        Node cur = head.next;
        while (cur != null && point <= num) {
            if (point == num) {
                pre.setNext(cur.next);
                cur.setNext(null);
                return true;
            } else {
                pre = pre.next;
                cur = cur.next;
                point++;
            }
        }
        return false;
    }

    class Node {
        public int value;
        public Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(map.isEmpty());
    }

}

