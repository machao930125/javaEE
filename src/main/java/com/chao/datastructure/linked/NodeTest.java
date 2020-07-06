package com.chao.datastructure.linked;

public class NodeTest {

    public Node mergeLink(Node head1, Node head2) {
        Node first = new Node(1);

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
                pre.next = (cur.next);
                cur.next = (null);
                return true;
            } else {
                pre = pre.next;
                cur = cur.next;
                point++;
            }
        }
        return false;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void print(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    /**
     * 初始化单链表
     *
     * @return
     */
    public static Node initSingleLink() {
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        Node head4 = new Node(4);
        Node head5 = new Node(5);
        Node head6 = new Node(6);
        Node head7 = new Node(7);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;

        return head1;
    }


    public static void main(String[] args) {
        Node node = initSingleLink();
//        Node node1 = initSingleLink();
//        print(node);
//        Node reverse = reverse(node);
//        print(reverse);
//        Node mid = findMid(reverse);
//        System.out.println(mid.value);
//        Node node1 = delNodeByVal(reverse, 1);
//        print(node1);
//        mid = findMid(node1);
//        System.out.println(mid.value);
//        Node node2 = mergeLink2(node, node1);
//        print(node2);

        Node node2 = reverseKGroup(node, 2);
        print(node2);
    }

    /**
     * K个一组翻转链表
     *
     * @param head
     * @param k
     * @return
     */
    public static Node reverseKGroup(Node head, int k) {
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


    /**
     * 翻转单链表
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        Node pre = null;
        Node temp = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    /**
     * 删除指定大小的Node节点
     *
     * @param head
     * @param num
     * @return
     */
    public static Node delNodeByVal(Node head, int num) {
        while (head != null && head.value == num) {
            head = head.next;
        }
        Node first = head;
        Node cur = head.next;
        Node pre = head;
        while (cur != null) {
            if (cur.value == num) {
                Node temp = cur.next;
                cur.next = null;
                pre.next = temp;
                cur = temp;
                pre = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return first;
    }

    /**
     * 查找链表中间节点
     *
     * @param head
     * @return
     */
    public static Node findMid(Node head) {
        Node fastNode = head;
        Node slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    /**
     * 合并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static Node mergeLink2(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.value < l2.value) {
            l1.next = mergeLink2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLink2(l1, l2.next);
            return l2;
        }
    }

}

