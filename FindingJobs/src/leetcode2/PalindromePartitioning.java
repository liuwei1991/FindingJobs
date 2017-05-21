package leetcode2;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(s==null||s.length()==0){
			return result;
		}
		this.solve(result, new ArrayList<String>(), s);
		return result;
    }
	
	private void solve(List<List<String>> result,List<String> list,String s){
		if(s.length()==0){
			result.add(new ArrayList<String>(list));
			return ;
		}
		for(int i=1;i<=s.length();i++){
			String tmp = s.substring(0, i);
			if(this.isPaline(tmp)){
				list.add(tmp);
				solve(result,list,s.substring(i));
				list.remove(list.size()-1);
			}
		}
	}
	private boolean isPaline(String s){
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i)){
				return false;
			}
		}
		return true;
	}
}
