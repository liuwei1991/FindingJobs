package astart.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
	public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
//        	注意，这个地方默认返回的是-1，而不是0
        	return -1;
        }
        char[] cs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:cs){
        	if(map.containsKey(c)){
        		map.put(c, map.get(c)+1);
        	}else{
        		map.put(c, 1);
        	}
        }
        for(int i=0;i<cs.length;i++){
        	if(map.get(cs[i])<=1){
        		return i;
        	}
        }
        return -1;
    }
}
