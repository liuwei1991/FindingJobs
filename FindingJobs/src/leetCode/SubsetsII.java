package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
		if(num == null){
			return null;
		}
		Arrays.sort(num);
		result.add(new ArrayList<Integer>());
		this.dfs(new ArrayList<Integer>(), num, 0);
		return result;
	}
	
	public void dfs(List<Integer> tmp,int[] num,int start){
		for(int i=start;i<num.length;i++){
			tmp.add(num[i]);
			result.add(new ArrayList<Integer>(tmp));
			dfs(tmp,num,i+1);
			tmp.remove(tmp.size()-1);
			while(i<num.length-1 && num[i] == num[i+1]){
				i++;
			}
		}
	}
	
	public static void main(String[] args){
		int[] num = {
				
		};
		SubsetsII ss = new SubsetsII();
		ss.subsetsWithDup(num);
	}
}
