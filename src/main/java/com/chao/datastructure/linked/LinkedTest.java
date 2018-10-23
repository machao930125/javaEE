package com.chao.datastructure.linked;

/**
 * Created by Admin on 2018/10/11.
 *
 *  https://blog.csdn.net/guyuealian/article/details/51119499
 * 1、单链表反转
 * 2、链表中环的检测
 * 3、两个有序的链表合并
 * 4、删除链表倒数第n个节点
 * 5、球链表的中间节点
 *
 * @author machao
 * @date 2018/10/16
 */
public class LinkedTest {

	public static void main(String[] args) {
		testReverse();
//		testCircle();
//		System.out.println(test(initSingleLinkedWithCircle()));
//		System.out.println(LinkedNode.findMidNode(initSingleLinked()).getData());
	}

	/**
	 * 测试链表中是否有环
	 */
	public static void testCircle(){
		LinkedNode head = initSingleLinkedWithCircle();
		System.out.println(LinkedNode.isLoopList(initSingleLinked()));
		System.out.println(LinkedNode.isLoopList(head));
	}

	/**
	 * 测试链表反转功能
	 */
	public static void testReverse(){
		LinkedNode head = initSingleLinked();

		// 打印反转前的链表
		LinkedNode h = head;
		while (null != h) {
			System.out.print(h.getData() + " ");
			h = h.getNext();
		}
		// 调用反转方法

//        head = reverse2(head);

		LinkedNode.deleteNode(head,5);
		System.out.println("\n**************************");
		// 打印反转后的结果
		while (null != head) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
	}

	/**
	 * 初始化单链表无环
	 *
	 * @return
	 */
	public static LinkedNode initSingleLinked(){
		LinkedNode head = new LinkedNode(0);
		LinkedNode linkedNode1 = new LinkedNode(1);
		LinkedNode linkedNode2 = new LinkedNode(2);
		LinkedNode linkedNode3 = new LinkedNode(3);
		LinkedNode linkedNode4 = new LinkedNode(4);
		head.setNext(linkedNode1);
		linkedNode1.setNext(linkedNode2);
		linkedNode2.setNext(linkedNode3);
		linkedNode3.setNext(linkedNode4);
		return head;
	}

	/**
	 * 初始化单链表带环
	 * @return
	 */
	public static LinkedNode initSingleLinkedWithCircle(){
		LinkedNode head = new LinkedNode(0);
		LinkedNode linkedNode1 = new LinkedNode(1);
		LinkedNode linkedNode2 = new LinkedNode(2);
		LinkedNode linkedNode3 = new LinkedNode(3);
		LinkedNode linkedNode4 = new LinkedNode(4);
		LinkedNode linkedNode5 = new LinkedNode(5);
		LinkedNode linkedNode6 = new LinkedNode(6);
		LinkedNode linkedNode7 = new LinkedNode(7);
		head.setNext(linkedNode1);
		linkedNode1.setNext(linkedNode2);
		linkedNode2.setNext(linkedNode3);
		linkedNode3.setNext(linkedNode4);
		linkedNode4.setNext(linkedNode5);
		linkedNode5.setNext(linkedNode6);
		linkedNode6.setNext(linkedNode7);
		linkedNode7.setNext(linkedNode3);
		return head;
	}

	public static boolean test(LinkedNode head){
		LinkedNode fast = head;
		LinkedNode slow = head;
		while (fast != null && fast.getNext() != null ){
			fast = fast.getNext().getNext();
			slow = slow.getNext();

			if (fast == slow){
				return true;
			}
		}
		return false;
	}
}

