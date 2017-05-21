package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> a = new LinkedList<TreeNode>();
        Queue<TreeNode> b = new LinkedList<TreeNode>();
        if(p == null && q ==null){
        	return true;
        }
        if(p==null || q==null){
        	return false;
        }
        if(p.val != q.val){
        	return false;
        }
        a.add(p);
        b.add(q);
        while(!a.isEmpty()){
        	TreeNode na = a.poll();
        	TreeNode nb = b.poll();
        	if(na.left!=null && nb.left!=null){
        		if(na.left.val != nb.left.val) return false;
        		a.add(na.left);
        		b.add(nb.left);
        	}else if(na.left!=null || nb.left !=null){
        		return false;
        	}
        	
        	if(na.right!=null && nb.right!=null){
        		if(na.right.val != nb.right.val){
        			return false;
        		}
        		a.add(na.right);
        		b.add(nb.right);
        	}else if(na.right!=null || nb.right!=null){
        		return false;
        	}
        }
        return true;
    }
	
}
