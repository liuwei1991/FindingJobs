package leetCode;

public class PopulatingNextRightPointersinEachNodeII {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	public void connect(TreeLinkNode root) {
		if(root==null){
			return;
		}
		if(root.left==null && root.right==null){
			return;
		}
		TreeLinkNode nextHead = null;
		TreeLinkNode current = root;
		TreeLinkNode past = null;
		while(current!=null){
			
			while(current!=null){
				if(current.left!=null && current.right!=null){
					if(nextHead ==null){
						nextHead = current.left;
					}
					current.left.next=current.right;
					if(past!=null){
						past.next = current.left;
					}
					past = current.right;
				}else if(current.left!=null){
					if(nextHead ==null){
						nextHead = current.left;
					}
					if(past!=null){
						past.next = current.left;
					}
					past = current.left;
				}else if(current.right!=null){
					if(nextHead ==null){
						nextHead = current.right;
					}
					if(past!=null){
						past.next = current.right;
					}
					past = current.right;
				}
				current = current.next;
			}
			current = nextHead;
			nextHead = null;
			past = null;
		}
		return;
    }
	public static void main(String[] args){
		PopulatingNextRightPointersinEachNodeII pn =new PopulatingNextRightPointersinEachNodeII();
		TreeLinkNode head= pn.new TreeLinkNode(1);
		head.left = pn.new TreeLinkNode(2);
		head.right = pn.new TreeLinkNode(3);
		head.left.left = pn.new TreeLinkNode(4);
		head.left.right = pn.new TreeLinkNode(5);
//		head.right = pn.new TreeLinkNode(3);
		head.right.right = pn.new TreeLinkNode(7);
		pn.connect(head);
	}
}
