package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> subsets(int[] S) {
		if(S==null){
			return null;
		}
		Arrays.sort(S);
		result.add(new ArrayList<Integer>());
		this.dfs(new ArrayList<Integer>(),S, 0);
		return result;
    }
	
	public void dfs(List<Integer> tmp, int[] s, int start){
		for(int i=start;i<s.length;i++){
			tmp.add(s[i]);
			result.add(new ArrayList<Integer>(tmp));
			dfs(tmp,s,i+1);
			tmp.remove(tmp.size()-1);
		}
	}
	
	public static void main(String args[]){
		Subsets s = new Subsets();
		int[] a = {1,3,2};
		s.subsets(a);
	}
}
