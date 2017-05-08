package astart.leetcode1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null){
			return result;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		List<Integer> tmp = new ArrayList<Integer>();
		while(q.size()!=0){
			TreeNode node = q.poll();
			if(node==null){
				result.add(new ArrayList<Integer>(tmp));
				tmp = new ArrayList<Integer>();
				if(q.size()!=0){
					q.add(null);
				}
			}else{
				tmp.add(node.val);
				if(node.left!=null){
					q.add(node.left);
				}
				if(node.right!=null){
					q.add(node.right);
				}
			}
		}
		return result;
    }
}
