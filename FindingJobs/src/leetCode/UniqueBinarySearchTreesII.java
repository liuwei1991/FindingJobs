package leetCode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> r= this.genTrees(1, n);
        return r;
    }
	public List<TreeNode> genTrees(int start,int end){
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start>end){
			result.add(null);
			return result;
		}
		if(start==end){
			result.add(new TreeNode(start));
			return result;
		}
		for(int i=start;i<=end;i++){
			List<TreeNode> left = this.genTrees(start,i-1); 
			List<TreeNode> right = this.genTrees(i+1, end);
			for(TreeNode l:left){
				for(TreeNode r:right){
					TreeNode cur = new TreeNode(i);
					cur.left=l;
					cur.right=r;
					result.add(cur);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		UniqueBinarySearchTreesII ub = new UniqueBinarySearchTreesII();
		int n = 3;
		ub.generateTrees(n);
	}
}