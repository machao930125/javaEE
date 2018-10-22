package com.chao.datastructure.linked;

import javax.sound.midi.Soundbank;

/**
 * 链表节点 LinkedNode
 *
 * @author machao
 * @date 2018/10/16
 */
public class LinkedNode<T> {
	/**
	 * 数据域
	 */
	private T Data;
	/**
	 * 指针域
	 */
	private LinkedNode Next;

	public LinkedNode(T Data) {
		// super();
		this.Data = Data;
	}

	public T getData() {
		return Data;
	}

	public void setData(T Data) {
		this.Data = Data;
	}

	public LinkedNode getNext() {
		return Next;
	}

	public void setNext(LinkedNode Next) {
		this.Next = Next;
	}

	/**
	 * 递归，在反转当前节点之前先反转后续节点
	 *
	 * @param head
	 * @return
	 */
	public static LinkedNode reverse1(LinkedNode head) {
		// head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
		if (head == null || head.getNext() == null) {
			// 若为空链或者当前结点在尾结点，则直接还回
			return head;
		}
		// 先反转后续节点head.getNext()
		LinkedNode reHead = reverse1(head.getNext());
		// 将当前结点的指针域指向前一结点
		head.getNext().setNext(head);
		// 前一结点的指针域令为null;
		head.setNext(null);
		// 反转后新链表的头结点
		return reHead;
	}

	/**
	 * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
	 *
	 * @param head 链表头结点
	 * @return
	 */
	public static LinkedNode reverse2(LinkedNode head) {
		if (head == null){
			return head;
		}
		// 上一结点
		LinkedNode pre = head;
		// 当前结点
		LinkedNode cur = head.getNext();
		// 临时结点，用于保存当前结点的指针域（即下一结点）
		LinkedNode tmp;
		// 当前结点为null，说明位于尾结点
		while (cur != null) {
			tmp = cur.getNext();
			// 反转指针域的指向
			cur.setNext(pre);
			// 指针往下移动
			pre = cur;
			cur = tmp;
		}
		// 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
		head.setNext(null);

		return pre;
	}
	/**
	 * 判断单链表是否存在环
	 * 采用快慢指针方式查找链表，事件复杂度为O(N)
	 * @param head
	 * @return
	 */
	public static <T> boolean isLoopList(LinkedNode<T> head){
		LinkedNode<T> slowPointer, fastPointer;

		//使用快慢指针，慢指针每次向前一步，快指针每次两步
		slowPointer = fastPointer = head;
		while(fastPointer != null && fastPointer.getNext() != null){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();

			//两指针相遇则有环
			if(slowPointer == fastPointer){
				return true;
			}
		}
		return false;
	}

	/**
	 *  查找链表中间节点
	 * @param head
	 * @param <T>
	 * @return
	 */
	public static<T> LinkedNode findMidNode(LinkedNode<T> head){
		LinkedNode<T> slowPointer, fastPointer;

		slowPointer = fastPointer = head;

		while (fastPointer != null && fastPointer.getNext() != null){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		return slowPointer;
	}

	/**
	 * 移除倒数第n个节点
	 *
	 * @param head
	 * @param num
	 */
	public static void deleteNode(LinkedNode head, int num){
		LinkedNode temp ;
		int count = head.count();

		int del = count -num -1 ;

		if (del < 0){
			temp = head.getNext();
			head = null;
			head = temp;
			return;
		}
		while (del >= 0){
			if (del == 0){
				temp = head.getNext().getNext();
				head.setNext(temp);
				break;
			}
			head = head.getNext();
			del --;
		}
	}

	public void deleteNodeByIndex(int index) {
		if (index < 1 || index > count()) {
			System.out.println("删除位置不合法");
		}
		LinkedNode temp = this;
		int length = 1;
		while (temp.getNext() != null) {
			if (index == length) {
				LinkedNode next = temp.getNext();
				next = temp.getNext().getNext();
				return;
			} else {
				temp = temp.getNext();
			}
			length++;
		}
	}

	/**
	 * 输出打印链表
	 */
	public void display(){
		if (this == null){
			System.out.println("empty");
		}
		LinkedNode cur = this;
		while (cur != null){
			System.out.println(cur.getData());
			cur = cur.getNext();
		}
	}

	/**
	 * 返回单链表的长度
	 *
	 * @return
	 */
	public int count(){
		int count = 0;
		LinkedNode cur = this;
		while (cur != null){
			count ++;
			cur = cur.getNext();
		}
		return count;
	}
}
