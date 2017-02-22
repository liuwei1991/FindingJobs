package astart.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow {
	public String[] findWords(String[] words) {
		String[] lines = {"qwertyuiop","asdfghjkl","zxcvbnm"};
		Map<Character,Integer> m = new HashMap<Character,Integer>();
		for(int i=0;i<lines.length;i++){
			for(char c:lines[i].toCharArray()){
				m.put(c, i);
			}
		}
		List<String> r = new ArrayList<String>();
		for(String word:words){
			int index = -1;
			for(char c:word.toLowerCase().toCharArray()){
				int curIndex = m.get(c);
				if(index==-1){
					index = curIndex;
				}else{
					if(index!=curIndex){
						index = -1;
						break;
					}
				}
			}
			if(index!=-1){
				r.add(word);
			}
        }
        return r.toArray(new String[0]);
    }
	
	public static void main(String[] args){
		KeyboardRow kr = new KeyboardRow();
		String[] s = {"qwerrytweqew","asdfga","SDGAgda","adswx"};
		for(String l:kr.findWords(s)){
			System.out.println(l);
		}
	}
}
