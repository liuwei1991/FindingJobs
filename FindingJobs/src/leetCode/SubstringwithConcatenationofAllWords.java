package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		if(S==null ||S.length()==0||L==null ||L.length==0){
			return null;
		}
		List<Integer> result = new ArrayList<Integer>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String s:L){
			if(map.containsKey(s)){
				map.put(s, map.get(s)+1);
			}else{
				map.put(s, 1);
			}
		}
		
		int len = L[0].length();
		for(int i=0;i<=(S.length()-len*L.length);i++){
			Map<String,Integer> tmp = new HashMap<String,Integer>(map);
			for(int j=i;j<=S.length()-len;j+=len){
				String str = S.substring(j,j+len);
				if(tmp.containsKey(str)){
					int count = tmp.get(str);
					if(count==1){
						tmp.remove(str);
					}else{
						tmp.put(str, count-1);
					}
				}else{
					break;
				}
			}
			if(tmp.isEmpty()){
				result.add(i);
			}
		}
		return result;
    }
	
	public static void main(String args[]){
		SubstringwithConcatenationofAllWords sc = new SubstringwithConcatenationofAllWords();
//		String s = "barfoothefoobarman";
//		String[] l = {"foo", "bar"};
//		String s = "abababab";
//		String[] l = {"a","b","a"};
		String s = "acaac";
		String[] l = {"ca", "ac"};
		sc.findSubstring(s, l);
	}
}
