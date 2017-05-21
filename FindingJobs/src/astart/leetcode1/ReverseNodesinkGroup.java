package astart.leetcode1;

import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class ReverseNodesinkGroup {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k<=1||head==null){
			return head;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode tmp = head;
		ListNode result = null;
		ListNode pre = null;
		ListNode nextFirst = null;
		while(tmp!=null){
			while(tmp!=null && stack.size()<k){
				stack.push(tmp);
				tmp = tmp.next;
			}
			if(stack.size()==k){
				if(result==null){
					result=stack.peek();
				}
				while(!stack.isEmpty()){
					if(pre==null){
						pre = stack.pop();
						continue;
					}
					pre.next = stack.pop();
					pre = pre.next;
				}
				nextFirst = tmp;
			}
		}
		if(pre!=null)
			pre.next= nextFirst;
		return result==null?head:result;
	}

		
	public ListNode reverse(ListNode head) {
		ListNode pre = null;
		while(head!=null){
			ListNode tmp = head.next;
			head.next=pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}
	
	public static void main(String[] args){
//		String str = new String("asdfa");
//		System.out.println(str.equals(new String("asdfa")));
//		System.out.println(str=="asdfa");
//		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		ConcurrentHashMap<Integer,Integer> m = new ConcurrentHashMap<Integer,Integer>();
		
		m.put(4, null);
	}
	
}
