package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意父节点与自己亲儿子交换的可能性
 * @author Ares
 *
 */
public class RecoverBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void recoverTree(TreeNode root) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		this.inOrderTravel(root, nodes);
		this.recover(nodes);
	}
	
	private void inOrderTravel(TreeNode root,List<TreeNode> nodes){
		if(root==null) return ;
		inOrderTravel(root.left,nodes);
		nodes.add(root);
		inOrderTravel(root.right,nodes);
	}
	
	private void recover(List<TreeNode> nodes){
		TreeNode first = null;
		TreeNode second = null;
		boolean findFirst = true;
		int firstIndex = 0;
		for(int i=0;i<nodes.size()-1;i++){
			if(nodes.get(i).val>nodes.get(i+1).val){
				if(findFirst){
					firstIndex = i;
					first = nodes.get(i);
					findFirst = false;
				}else{
					second = nodes.get(i+1);
					break;
				}
			}
		}
		if(first!=null && second!=null){
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}else if(first!=null){
			int tmp = first.val;
			first.val = nodes.get(firstIndex+1).val;
			nodes.get(firstIndex+1).val = tmp;
		}
	}
	public static void main(String args[]){
		RecoverBinarySearchTree rb = new RecoverBinarySearchTree();
		TreeNode head = rb.new TreeNode(1);
		head.left = rb.new TreeNode(2);
		head.right = rb.new TreeNode(3);
		rb.recoverTree(head);
		int i=1;
	}
}
