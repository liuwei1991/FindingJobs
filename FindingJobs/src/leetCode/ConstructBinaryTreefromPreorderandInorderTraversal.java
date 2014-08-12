package leetCode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode tn = this.getTree(preorder, inorder, 0, preorder.length - 1,
				0, inorder.length - 1);
		return tn;
	}

	public TreeNode getTree(int[] pre, int[] in, int pStart, int pEnd,
			int iStart, int iEnd) {
		if (pStart > pEnd) {
			return null;
		}
		TreeNode root = new TreeNode(pre[pStart]);
		int i = iStart;
		for (; i < in.length; i++) {
			if (in[i] == pre[pStart]) {
				break;
			}
		}
		root.left = this.getTree(pre, in, pStart + 1, pStart + i - iStart,
				iStart, i - 1);
		root.right = this.getTree(pre, in, pStart + i - iStart + 1, pEnd,
				i + 1, iEnd);
		return root;
	}
	
	public static void main(String[] args){
		ConstructBinaryTreefromPreorderandInorderTraversal cb = new ConstructBinaryTreefromPreorderandInorderTraversal();
		int pre[] = {1,2,4,5,3};
		int in[] ={4,2,5,1,3};
		cb.buildTree(pre, in);
	}
}
