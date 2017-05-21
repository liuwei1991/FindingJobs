package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			if (map.containsKey(T.charAt(i))) {
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			} else {
				map.put(T.charAt(i), 1);
			}
		}
		int count = 0;
		int pre = 0;
		String result ="";
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < S.length(); i++) {
			if(map.containsKey(S.charAt(i))){
				map.put(S.charAt(i), map.get(S.charAt(i))-1);
				if(map.get(S.charAt(i))>=0){
					count++;
				}
				while(count == T.length()){
					if(map.containsKey(S.charAt(pre))){
						if(map.get(S.charAt(pre))<0){
							map.put(S.charAt(pre), map.get(S.charAt(pre))+1);
							pre++;
						}else{
							map.put(S.charAt(pre), map.get(S.charAt(pre))+1);
							if(min>i-pre+1){
								min = i-pre+1;
								result = S.substring(pre,pre+min);
							}
							pre++;
							count --;
						}
					}else{
						pre++;
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args){
		MinimumWindowSubstring mw = new MinimumWindowSubstring();
		String s ="ADOBECODEBANC";
		String t = "ABC";
		System.out.println(mw.minWindow(s, t));
	}
}
