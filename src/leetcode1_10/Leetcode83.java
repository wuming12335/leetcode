package leetcode1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 输入: 1->1->2 输出: 1->2 
 * 示例 2:
 * 输入: 1->1->2->3->3 输出: 1->2->3
 *1 2 2 2
 */
public class Leetcode83 {
	
	//这个方法虽然能够通过测试，但是还有问题，比如1—>2->2->1如果两个1中间隔开的有数，则会成为1->2->1,结果不对，需要改进。
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next==null) {
			return head;
		}
		ListNode p = head,q;
		int val;
		q = p.next;
		for(;q.next!=null;) {
			 val = p.val;
			if(val == q.val) {
				p.next = q.next;
				q = p.next;
			}else {
				p = q;
				q = p.next;
			}
		}
		
		
		if(p.val == q.val) {
			p.next = null;
		}
		
		
		return head;
	}
	
	
	//改进后：
	public static ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next==null) {
			return head;
		}
		List<Integer> list = new ArrayList<>();
		ListNode p = head,q;
		int val;
		q = p.next;
		for(;q.next!=null;) {
			 val = p.val;
			 list.add(val);
			if(val == q.val) {
				p.next = q.next;
				q = p.next;
			}else if(list.contains(q.val)) {
				if(q.next!=null) {
					p.next = q.next;
					q = p.next;
				}else {
					p.next = null;
				}
			}
			else {
				p = q;
				q = p.next;
			}
		}
		
		if(p.val == q.val) {
			p.next = null;
		}
		
		
		return head;
	}
	
	//官方法：最终效果与自己的改进前的效果一样，无法除去相隔的重复数
	public static ListNode deleteDuplicates3(ListNode head) {
	    ListNode current = head;
	    while (current != null && current.next != null) {
	        if (current.next.val == current.val) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}

	public static void main(String[] args) {
		ListNode p = null,q,head=new ListNode(1);
		p = head;
		q = new ListNode(2);
		p.next = q;
		p=q;
		q = new ListNode(2);
		p.next = q;
		p=q;
		q = new ListNode(1);
		p.next =q;
		p=q;
		q=new ListNode(2);
		p.next = q;
		
		
		ListNode node = deleteDuplicates3(head);
		
		System.out.println(head);
	}
}
/*
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
*/
