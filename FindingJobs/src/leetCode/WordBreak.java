package leetCode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	 public boolean wordBreak(String s, Set<String> dict) {
		 boolean[] dp = new boolean[s.length()+1];
		 dp[0] = true;
		 for(int i=0;i<s.length();i++){
			 if(dp[i]){
				 for(int j=i+1;j<=s.length();j++){
					 if(dict.contains(s.substring(i, j))){
						 dp[j] = true;
					 }
				 }
			 }
		 }
		 return dp[s.length()];
	 }
	 
	 public static void main(String[] args){
		 Set<String> s = new HashSet<String>();
		 s.add("a");
		 WordBreak wb = new WordBreak();
		 System.out.println(wb.wordBreak("a", s));
	 }
}
