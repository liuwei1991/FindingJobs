package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
		Map<String,List<String>> m = new HashMap<String,List<String>>();
		for(int i=0;i<strs.length;i++){
			String str = strs[i];
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String tmp = String.valueOf(chars);
			if(m.containsKey(tmp)){
				List<String> l = m.get(tmp);
				l.add(str);
			}else{
				List<String> l = new ArrayList<String>();
				l.add(str);
				m.put(tmp, l);
			}
		}
		Iterator<String> it = m.keySet().iterator();
		while(it.hasNext()){
			List<String> list= m.get(it.next());
			if(list.size()>1){
				result.addAll(list);
			}
		}
		return result;
    }
	
	public static void main(String args[]){
		Anagrams a = new Anagrams();
		String[] strs = {"",""};
		a.anagrams(strs);
	}
}
