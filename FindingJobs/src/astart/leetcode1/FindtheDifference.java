package astart.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class FindtheDifference {
	public char findTheDifference(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:cs){
        	if(map.containsKey(c)){
        		map.put(c, map.get(c)+1);
        	}else{
        		map.put(c, 1);
        	}
        }
        
        for(char c:ct){
        	if(!map.containsKey(c)||map.get(c)==0){
        		return c;
        	}else{
        		map.put(c, map.get(c)-1);
        	}
        }
        return ' ';
    }
}
