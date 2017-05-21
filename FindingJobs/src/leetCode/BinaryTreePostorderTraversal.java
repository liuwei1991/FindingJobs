package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(root == null){
	        	return result;
	        }
	        s.add(root);
	        this.solve(result, s);
	        return result;
	}

	public void solve(ArrayList<Integer> result,Stack<TreeNode> s){
		if(s.size() ==0){
			return ;
		}
		TreeNode current = s.lastElement();
		if(current!=null){
//			s.add(current);
			if(current.left!=null){
				s.add(current.left);
				current.left = null;
				this.solve(result, s);
			}
			if(s.size()==0){
				return;
			}
			if(current.right!=null){
				s.add(current.right);
				current.right = null;
				this.solve(result, s);
			}
			if(s.size() ==0){
				return;
			}
				
			if(current.right ==null && current.left == null){
				result.add(s.pop().val);
				current = null;
				this.solve(result, s);
			}
		}
	}
	
	public static void main(String[] args){
		BinaryTreePostorderTraversal btp = new BinaryTreePostorderTraversal();
		TreeNode root = btp.new TreeNode(1);
		root.left = btp.new TreeNode(2);
		root.left.left = btp.new TreeNode(4);
		root.right = btp.new TreeNode(3);
		root.right.left = btp.new TreeNode(5);
		root.right.right = btp.new TreeNode(6);
		root.right.right.left = btp.new TreeNode(8);
		root.right.left.right = btp.new TreeNode(7);
		for(int i:btp.postorderTraversal(root)){
			System.out.print(i+"  ");
		}
	}
}
