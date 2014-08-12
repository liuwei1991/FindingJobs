package leetCode;
import java.util.Iterator;
import java.util.TreeMap;

public class LRUCache {
	private int  capacity= 0;
	private int elementNum = 0;
	private TreeMap<Integer,Integer> keyValue = new TreeMap<Integer,Integer>();
//	private ArrayList<> ; 
	private TreeMap<Integer,Integer> keyNum = new TreeMap<Integer,Integer>();
	
	public LRUCache(int capacity) {
	        this.capacity = capacity;
	}
	    
	public int get(int key) {
	        if(keyValue.containsKey(key)){
	        	keyNum.put(key, keyNum.get(key)+1);
	        	return keyValue.get(key);
	        }else{
	        	return -1;
	        }
	}
	
	public void set(int key, int value) {
	    if(keyValue.containsKey(key)){
	    	keyValue.put(key, value);
	    	keyNum.put(key, keyNum.get(key)+1);
	    }else{
	    	if(this.elementNum < this.capacity){
	        	this.elementNum ++;
	        	keyValue.put(key, value);
	        	keyNum.put(key, 1);
	    	}else{
	    		Iterator<Integer> it = keyNum.keySet().iterator();
	    		int smallKey = -1;
	    		int smallValue = Integer.MAX_VALUE;
	    		while(it.hasNext()){
	    			int keyTmp = it.next();
	    			if(keyNum.get(keyTmp) < smallValue){
	    				smallKey = keyTmp;
	    				smallValue = keyNum.get(keyTmp); 
	    			}
	    		}
	    		keyValue.remove(smallKey);
	    		keyNum.remove(smallKey);
	        	keyValue.put(key, value);
	        	keyNum.put(key, 1);
	    	}
	    }
	}
	
	public static void main(String args[]){
		LRUCache lc = new LRUCache(3);
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
