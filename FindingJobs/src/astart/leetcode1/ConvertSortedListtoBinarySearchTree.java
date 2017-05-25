package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
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
		if (head == null) {
			return null;
		}
		List<ListNode> nums = new ArrayList<ListNode>();
		while (head != null) {
			nums.add(head);
			head = head.next;
		}
		return this.solve(nums, 0, nums.size() - 1);
	}

	public TreeNode solve(List<ListNode> nums, int start, int end) {
		if (start > end) {
			return null;
		}
		TreeNode head = new TreeNode(nums.get((start + end) / 2).val);
		head.left = this.solve(nums, start, (start + end) / 2 - 1);
		head.right = this.solve(nums, (start + end) / 2 + 1, end);
		return head;
	}

}
