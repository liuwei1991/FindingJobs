package leetCode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LRUCache {
	
	class Node{
		int key;
		int value;
		Node next = null;
		Node pre = null;
		
		Node(int key,int value){
			this.key = key;
			this.value = value;
		}
	}
	
	int capacity  = 0;
	Node head = new Node(0,0);
	Node tail = new Node(1,1);
	Map<Integer,Node> map = new HashMap<Integer,Node>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.pre = head;
	}
	
	public int get(int key) {
		Node cur = map.get(key);
		if(cur!=null){
			delete(cur);
			insert(cur);
			return cur.value;
		}
		return -1;
	}
	
	public void set(int key, int value) {
		if(this.capacity==0) return;
		if(map.containsKey(key)){
			Node node = map.get(key);
			delete(node);
			insert(new Node(key,value));
		}else{
			if(map.size()<this.capacity){
				insert(new Node(key,value));
			}else{
				delete();
				insert(new Node(key,value));
			}
		}
	}
	
	private void delete(Node node){
		Node cur = head.next;
		while(cur!=tail){
			if(cur.key == node.key){
				cur.pre.next = cur.next;
				cur.next.pre = cur.pre;
				map.remove(node.key);
			}
			cur = cur.next;
		}
	}
	
	private void delete(){
		if(map.size()==0){
			return;
		}
		map.remove(tail.pre.key);
		Node pre = tail.pre.pre;
		pre.next = tail;
		tail.pre = pre;
	}
	
	private void insert(Node node){
		if(map.size()>=this.capacity){
			return;
		}
		Node next = head.next;
		head.next = node;
		node.pre = head;
		node.next = next;
		next.pre = node;
		map.put(node.key, node);
	}
	
	public static void main(String args[]){
		LRUCache lc = new LRUCache(2);
		lc.set(2, 1);
		lc.set(2, 2);
		System.out.println(lc.get(2));
		lc.set(1, 1);
		lc.set(4, 1);
		System.out.println(lc.get(2));
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(1, 1);
		lc.set(2, 2);
		lc.set(3, 3);
		lc.set(4, 4);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(6, 6);
		lc.set(7, 7);
		lc.set(0, 0);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(1, 1);
		lc.set(2, 2);
		lc.set(3, 3);
		lc.set(4, 4);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(6, 6);
		lc.set(7, 7);
		lc.set(0, 0);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(1, 1);
		lc.set(2, 2);
		lc.set(3, 3);
		lc.set(4, 4);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(6, 6);
		lc.set(7, 7);
		lc.set(0, 0);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(2, 2);
		lc.set(1, 1);
		lc.set(2, 2);
		lc.set(3, 3);
		lc.set(4, 4);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(5, 5);
		lc.set(6, 6);
		lc.set(7, 7);
	}
}
