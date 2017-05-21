package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		 this.maxValue(root);
		 return max;
	}
	
	public int maxValue(TreeNode root){
		if(root.left==null && root.right==null){
			max = Math.max(max, root.val);
			return root.val;
		}
		int lmax = Integer.MIN_VALUE;
		int rmax = Integer.MIN_VALUE;
		int value = root.val;
		
		if(root.left!=null){
			lmax = maxValue(root.left);
			if(lmax>0){
				value +=lmax;
			}
		}
		if(root.right!=null){
			rmax = maxValue(root.right);
			if(rmax>0){
				value += rmax;
			}
		}
		max = Math.max(value, max);
		return Math.max(root.val, Math.max(lmax, rmax)+root.val);
	}
	
	public static void main(String args[]){
		
	}
}
