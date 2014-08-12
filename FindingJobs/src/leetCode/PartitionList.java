package leetCode;

public class PartitionList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
        	return head;
        }
		ListNode point = head;
		if(head.val>=x){
			point = null;
		}else{
			while(point.next!=null && point.next.val<x){
				point = point.next;
			}
			if(point.next==null){
				return head;
			}
		}
		ListNode cur ;
		if(point !=null){
			cur = point.next.next;
		}else{
			cur = head;
		}
        while(cur!=null){
        	if(cur.val<x){
        		if(cur.next==null){
        			int a = cur.val;
        			if(point ==null){
        				point = cur;
        				point.next = head;
        				head = point;
        				while(point.next.next!=null && point.next.val!=a){
            				point=point.next;
            			}
        			}else{
        				ListNode tmp = new ListNode(cur.val);
        				tmp.next = point.next;
        				point.next = tmp;
        				while(point.next.next!=null){
            				point=point.next;
            			}
        			}
        			while(point.next.next!=null && point.next.val!=a){
        				point=point.next;
        			}
        			point.next=null;
        			cur = null;
        			break;
        		}else{
        			if(point ==null){
        				int curBc = cur.next.val;
        				cur.next.val= cur.val;
        				cur.val=curBc;
        				point = cur.next;
        				cur.next = cur.next.next;
        				point.next=head;
        				head = point;
        			}else{
        				ListNode pointNextBc = point.next;
        				int curBc = cur.next.val;
        				cur.next.val= cur.val;
        				cur.val=curBc;
        				point.next = cur.next;
        				cur.next = cur.next.next;
        				point.next.next=pointNextBc;
        				point = point.next;
        			}
        			continue;
        		}
        	}
        	cur = cur.next;
        }
        return head;
    }
	public static void main(String[] args){
		PartitionList pl = new PartitionList();
		ListNode head = pl.new ListNode(1);
		head.next = pl.new ListNode(3);
		head.next.next = pl.new ListNode(2);
//		head.next.next.next= pl.new ListNode(2);
//		head = pl.new ListNode(1);
//		head = pl.new ListNode(1);
		int x =3;
		pl.partition(head, x);
	}
}
