package com.chao.datastructure.linked;


class DoubleLinkedList {

    public Node head;

    public DoubleLinkedList(Node head){
    	this.head = head;
	}

    public void list() {
        if (head.next == null) {
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
		node.pre = temp;
    }

    public void delate(int value) {
        if (head.next == null) {
            return;
        }

        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.value == value) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }
}
