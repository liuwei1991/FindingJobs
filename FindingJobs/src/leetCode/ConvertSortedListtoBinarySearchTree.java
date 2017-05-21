package leetCode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head ==null){
			return null;
		}
		if(head.next==null){
			return new TreeNode(head.val);
		}
		List<Integer> value = new ArrayList<Integer>();
		ListNode tmp = head;
		while(tmp!=null){
			value.add(tmp.val);
			tmp = tmp.next;
		}
		TreeNode tn = this.listToBST(value, 0, value.size()-1);
		return tn;
	}
	
	public TreeNode listToBST(List<Integer> value,int start,int end){
		if(start>end){
			return null;
		}
		if(start==end){
			return new TreeNode(value.get(start));
		}
		int mid = (start+end)/2;
		TreeNode tn = new TreeNode(value.get(mid));
		tn.left = listToBST(value,start,mid-1);
		tn.right = listToBST(value,mid+1,end);
		return tn;
	}
	public static void main(String[] args){
		ConvertSortedListtoBinarySearchTree cs = new ConvertSortedListtoBinarySearchTree();
		ListNode head = cs.new ListNode(1);
		head.next = cs.new ListNode(2);
		head.next.next = cs.new ListNode(3);
		head.next.next.next = cs.new ListNode(4);
		head.next.next.next.next= cs.new ListNode(5);
//		head.next.next.next.next.next = cs.new ListNode(6);
		cs.sortedListToBST(head);
	}
}
