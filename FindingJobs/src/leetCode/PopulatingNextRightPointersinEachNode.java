package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root == null){
        	return ;
        }
        q.add(root);
        int pNum = 1;
        int cNum = 0;
        while(!q.isEmpty()){
        	cNum = 0;
        	TreeLinkNode preNode = q.poll();
        	if(preNode.left!=null){
        		q.add(preNode.left);
        		cNum++;
        	}
        	if(preNode.right!=null){
        		q.add(preNode.right);
        		cNum++;
        	}
        	for(int i=1;i<pNum;i++){
        		TreeLinkNode curNode = q.poll();
        		preNode.next = curNode;
        		preNode = curNode;
        		if(preNode.left!=null){
            		q.add(preNode.left);
            		cNum++;
            	}
            	if(preNode.right!=null){
            		q.add(preNode.right);
            		cNum++;
            	}
        	}
        	pNum = cNum;
        	preNode.next = null;
        }
    }
	
}
