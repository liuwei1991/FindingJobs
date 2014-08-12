package leetCode;

public class ConvertSortedArraytoBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode sortedArrayToBST(int[] num) {
        if(num ==null) return null;
        if(num.length==0) return null;
        TreeNode head = this.createTree(0, num.length, num);
        return head;
    }
	/*
	 * not contain 'end'
	 */
	public TreeNode createTree(int start,int end,int[] num){
		if(start == end ) return null;
		 TreeNode head = new TreeNode(num[(start+end)/2]);
	     if(end-start <= 1){
	    	 return head;
	     }
	     head.left = this.createTree(start,(start+end)/2, num);
	     head.right = this.createTree((start+end)/2+1, end, num);
	     return head;
	}
	
	public static void main(String[] args){
		ConvertSortedArraytoBinarySearchTree cs = new ConvertSortedArraytoBinarySearchTree();
		int[] num = {0,1,2,3,4,5};
		int[] num2 = {0,1,2,3,4,5,6};
		cs.sortedArrayToBST(num);
		cs.sortedArrayToBST(num2);
	}
}
