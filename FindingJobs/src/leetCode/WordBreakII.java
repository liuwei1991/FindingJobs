package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	 private Map<Integer,ArrayList<String>> result = new HashMap<Integer,ArrayList<String>>();
	 private String s;
	 private Set<String> dict;
	 private int N;
	 
	 public List<String> wordBreak(String s, Set<String> dict) {
		 if(s == null || s.length()==0 || dict ==null || dict.size()<=0){
			 return new ArrayList<String>();
		 }
		 this.s = s;
		 this.dict = dict;
		 this.N = s.length();
		 return this.solve(0);
	 }
	 
	 public ArrayList<String> solve(int i){
		 if(result.containsKey(i)){
			 return result.get(i);
		 }
		 ArrayList<String> list = new ArrayList<String>();
		 if(i>=N){
			 result.put(i, list);
			 return list;
		 }
		 for(int j=i+1;j<=N;j++){
			 String word = s.substring(i,j);
			 if(dict.contains(word)){
				 ArrayList<String>  sublist= solve(j);
				 ArrayList<String> tmp = new ArrayList<String>();
				 if(sublist==null){
					 continue;
				 }if( sublist.size()==0){
					 tmp.add(word);
				 }else{
					 for(String ss:sublist){
						 tmp.add(word+" "+ss);
					 }
				 }
				 list.addAll(tmp);
			 }
		 }
		 if(list.size()==0){
			 list = null;
		 }
		 result.put(i, list);
		 return list;
	 }
	 
	 public static void main(String[] args){
		 Set<String> s = new HashSet<String>();
		 s.add("cat");
		 s.add("cats");
		 s.add("and");
		 s.add("sand");
		 s.add("dog");
		 s.add("a");
//		 s.add("aa");
		 WordBreakII wb = new WordBreakII();
//		 String str = "cata";
		 String str = "catsanddoga";
		 System.out.println(wb.wordBreak(str, s));
	 }
}
