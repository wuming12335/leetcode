package leetcode1_10;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

/*
 * 21. 合并两个有序链表
 */
/*
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
	示例：
	输入：1->2->4, 1->3->4
	输出：1->1->2->3->4->4
 */
public class Leetcode21 {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode listnode;
		ListNode p = new ListNode(0);
		listnode = p;
		
		while(l1!=null && l2!=null) {
			if(l1.val>l2.val) {
				ListNode q = new ListNode(l2.val);
				p.next = q;
				p=q;
				l2 = l2.next;
			}else {
				ListNode q = new ListNode(l1.val);
				p.next = q;
				p=q;
				l1 = l1.next;
			}
		}
		if(l1!=null) {
			p.next = l1;
		}else {
			p.next = l2;
		}
		
		
		return listnode.next;

	}

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
	}
	
}



