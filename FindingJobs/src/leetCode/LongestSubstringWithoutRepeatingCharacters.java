package leetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0) return 0;
		if(s.length()==1) return 1;
		Set<Character> exsist = new HashSet<Character>();
		int start = 0;
		int end = 1;
		exsist.add(s.charAt(0));
		int result = 1;
		while(end<s.length()){
			if(!exsist.contains(s.charAt(end))){
				if(result<(end-start+1)){
					result = end - start+1;
				}
				exsist.add(s.charAt(end));
			}else{
				for(int i=start;i<=end;i++){
					if(s.charAt(i)==s.charAt(end)){
						start = i+1;
						break;
					}else{
						exsist.remove(s.charAt(i));
					}
				}
			}
			end++;
		}
		return result;
    }
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		String s = "abcabcbb";
		System.out.println(ls.lengthOfLongestSubstring(s));
	}
}
