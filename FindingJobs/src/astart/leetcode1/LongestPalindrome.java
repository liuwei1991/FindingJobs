package astart.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		char[] sc = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:sc){
        	if(map.containsKey(c)){
        		map.put(c, map.get(c)+1);
        	}else{
        		map.put(c, 1);
        	}
        }
        int r = 0;
        for(char c:map.keySet()){
        	r += map.get(c);
        	if(map.get(c)%2==1){
        		r=r-1;
        	}
        }
        if(r!=sc.length){
        	r+=1;
        }
        return r;
    }
}
