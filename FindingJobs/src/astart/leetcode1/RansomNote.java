package astart.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        char[] sc1 = ransomNote.toCharArray();
        char[] sc2 = magazine.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:sc2){
        	if(map.containsKey(c)){
        		map.put(c, map.get(c)+1);
        	}else{
        		map.put(c, 1);
        	}
        }
        
        for(char c:sc1){
        	if(map.containsKey(c) && map.get(c)>0){
        		map.put(c, map.get(c)-1);
        	}else{
        		return false;
        	}
        }
        return true;
    }
}
