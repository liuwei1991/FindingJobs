package astart.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
	private List<String> result = new ArrayList<String>();
	
	public List<String> wordBreak(String s, List<String> wordDict) {
        this.solve(s, 0, wordDict, "");
        return result;
    }
	
	public void solve(String s,int start,List<String> wordDict,String before){
		if(start==s.length()){
			result.add(before.trim());
			return;
		}
		for(String word:wordDict){
			if(start+word.length()<=s.length() && s.substring(start,start+word.length()).equals(word)){
				this.solve(s, start+word.length(), wordDict, before+" "+word);
			}
		}
	}
	
	public static void main(String[] args){
		WordBreakII wb = new WordBreakII();
		String s = "catsanddog";
		String[] dict = {"cat", "cats", "and", "sand", "dog"};
		for(String str:wb.wordBreak(s, Arrays.asList(dict))){
			System.out.println(str);
		}

	}
}
