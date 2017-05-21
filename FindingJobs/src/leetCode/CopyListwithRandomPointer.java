package leetCode;

public class CopyListwithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
        	return null;
        }
        RandomListNode cur = head;
        while(cur!=null){
        	RandomListNode tmp = new RandomListNode(cur.label);
        	tmp.next= cur.next;
        	cur.next = tmp;
        	cur=cur.next.next;
        }
        cur = head;
        while(cur!=null){
        	if(cur.random!=null){
        		cur.next.random = cur.random.next;
        	}
        	cur = cur.next.next;
        }
        cur = head;
        RandomListNode result = head.next;
        while(cur!=null){
        	RandomListNode tmp = cur.next;
        	cur.next = cur.next.next;
        	if(cur.next!=null)tmp.next = tmp.next.next;
        	cur = cur.next;
        }
        return result;
    }
	public static void main(String[] args){
		CopyListwithRandomPointer cl = new CopyListwithRandomPointer();
		RandomListNode rl = cl.new RandomListNode(1);
		RandomListNode result = cl.copyRandomList(rl);
		int i=1;
		i+=1;
	}
}
