package leetCode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode tn = this.getTree(postorder, inorder, 0, inorder.length - 1,0, inorder.length - 1);
		return tn;
	}

	public TreeNode getTree(int[] post, int[] in, int pStart, int pEnd,
			int iStart, int iEnd) {
		if (pStart > pEnd) {
			return null;
		}
		TreeNode root = new TreeNode(post[pEnd]);
		int i = iEnd;
		for (; i >=0; i--) {
			if (in[i] == post[pEnd]) {
				break;
			}
		}
		root.left = this.getTree(post, in, pStart, pStart + i - iStart-1,
				iStart, i - 1);
		root.right = this.getTree(post, in, pStart + i - iStart, pEnd-1,
				i + 1, iEnd);
		return root;
	}
	
	public static void main(String[] args){
		ConstructBinaryTreefromInorderandPostorderTraversal cb = new ConstructBinaryTreefromInorderandPostorderTraversal();
		int post[] = {4,5,2,3,1};
		int in[] ={4,2,5,1,3};
		cb.buildTree(in,post);
	}
}
