package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root==null){
			return result;
		}
		this.findPath(root, 0, sum, new ArrayList<Integer>());
		return result;
	}
	
	public void findPath(TreeNode node,int curSum,int target,List<Integer> path){
		if(node.left==null && node.right==null && curSum+node.val == target){
			path.add(node.val);
			result.add(new ArrayList<Integer>(path));
			path.remove(path.size()-1);
			return;
		}
		path.add(node.val);
		if(node.left!=null){
			this.findPath(node.left, curSum+node.val, target, path);
		}
		if(node.right!=null){
			this.findPath(node.right, curSum+node.val, target, path);
		}
		path.remove(path.size()-1);
	}
}
