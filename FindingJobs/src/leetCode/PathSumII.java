package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private int target;
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this.target = sum;
		this.getPath(result, new ArrayList<Integer>(), root, 0);
		return result;
	}
	
	public void getPath(List<List<Integer>> result,List<Integer> tmp,TreeNode current,int presum){
		if(current ==null){
			return;
		}
		if(current.left==null && current.right==null && (presum+current.val)==target){
			tmp.add(current.val);
			result.add(new ArrayList<Integer>(tmp));
			tmp.remove(tmp.size()-1);
			return;
		}
		presum+=current.val;
		tmp.add(current.val);
		this.getPath(result, tmp, current.left, presum);
		this.getPath(result, tmp, current.right, presum);
		tmp.remove(tmp.size()-1);
	}
	public static void main(String[] args){
		PathSumII ps = new PathSumII();
		TreeNode tn =ps.new TreeNode(5);
		tn.left =ps.new TreeNode(4);
		tn.left.left =ps.new TreeNode(11);
		tn.left.left.left =ps.new TreeNode(7);
		tn.left.left.right =ps.new TreeNode(2);
		tn.right =ps.new TreeNode(8);
		tn.right.left =ps.new TreeNode(13);
		tn.right.right =ps.new TreeNode(4);
		tn.right.right.left =ps.new TreeNode(5);
		tn.right.right.right=ps.new TreeNode(1);
		ps.pathSum(tn, 22);
	}
}
