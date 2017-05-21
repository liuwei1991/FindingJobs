package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	Map<Integer,List<String>> result = new HashMap<Integer,List<String>>();
	int N = -1;
	String s  = "";
	Set<String> dict = new HashSet<String>();
	
	public List<String> wordBreak(String s, Set<String> dict) {
		if(s==null||s.length()==0){
			return new ArrayList<String>();
		}
		this.s = s;
		N = s.length();
		this.dict = dict;
		this.solve(0);
		return result.get(0);
    }
	
	public List<String> solve(int m){
		List<String> resultM = new ArrayList<String>();
		if(m>=N){
			resultM.add("");
			return resultM;
		}
		if(result.containsKey(m)){
			return result.get(m);
		}
		
		for(int i=m+1;i<=N;i++){
			String tmp = s.substring(m, i);
			if(dict.contains(tmp)){
				List<String> resultI = this.solve(i);
				for(String str:resultI){
					resultM.add((tmp+" "+str).trim());
				}
			}
		}
		result.put(m, resultM);
		return resultM;
	}
	
	public boolean wordBreak1(String s, Set<String> dict) {
		if(s==null) return false;
        if(s.length()==0){
        	return true;
        }
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
        	if(dp[i-1]){
        		for(int j=i+1;j<=s.length()+1;j++){
        			String tmp = s.substring(i-1, j-1);
        			if(dict.contains(tmp)){
        				dp[j-1] = true;
        			}
        		}
        	}
        }
        return dp[s.length()];
    }
	
	public static void main(String[] args){
		WordBreakII wb = new WordBreakII();
		String s ="catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		wb.wordBreak(s, dict);
	}
}
