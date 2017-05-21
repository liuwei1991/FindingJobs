package leetCode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		if(start.endsWith(end)){
			return 1;
		}
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        q.add("");
        int count = 1;
        while(!q.isEmpty()){
        	String cur = q.poll();
        	if(cur!=""){
        		int len = cur.length();
        		for(int i=0;i<len;i++){
        			for(char c ='a';c<='z';c++){
        				String tmp = cur.substring(0,i)+c+cur.substring(i+1);
        				if(tmp.equals(end)){
        					return count+1;
        				}
        				if(dict.contains(tmp)){
        					q.add(tmp);
        					dict.remove(tmp);
        				}
        			}
        		}
        	}else if(!q.isEmpty()){
        		count++;
        		q.add("");
        	}
        }
		return 0;
    }
	
	
	public static void main(String[] args){
//		String start = "hit";
//		String end = "cog";
//		Set<String> s = new LinkedHashSet<String>();
//		s.add("hot");
//		s.add("dot");
//		s.add("dog");
//		s.add("lot");
//		s.add("log");
		String start = "a";
		String end = "c";
		Set<String> s = new LinkedHashSet<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("lot");
		s.add("log");
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(start, end, s));
	}
}
