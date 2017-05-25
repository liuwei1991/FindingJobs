package astart.leetcode1;

public class ConvertSortedArraytoBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return this.solve(nums, 0, nums.length - 1);
	}

	public TreeNode solve(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		TreeNode head = new TreeNode(nums[(start + end) / 2]);
		head.left = this.solve(nums, start, (start + end) / 2 - 1);
		head.right = this.solve(nums, (start + end) / 2 + 1, end);
		return head;
	}

}
