package astart.leetcode1;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int result = 1;
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur == null && !q.isEmpty()) {
				q.add(null);
				result += 1;
				continue;
			} else if (cur == null && q.isEmpty()) {
				break;
			}
			if (cur.left == null && cur.right == null) {
				return result;
			}
			if (cur.left != null) {
				q.add(cur.left);
			}
			if (cur.right != null) {
				q.add(cur.right);
			}
		}
		return 1;
	}

}
