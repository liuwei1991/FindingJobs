package astart.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(s==null && t==null){
        	return true;
        }
        if(s==null && t!=null || s!=null && s==null){
        	return false;
        }
        if(s.length()!=t.length()){
        	return false;
        }
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:ss){
        	if(map.containsKey(c)){
        		map.put(c, map.get(c)+1);
        	}else{
        		map.put(c, 1);
        	}
        }
        for(char c:ts){
        	if(map.containsKey(c) && map.get(c)>0){
        		map.put(c, map.get(c)-1);
        	}else{
        		return false;
        	}
        }
        return true;
    }
}
