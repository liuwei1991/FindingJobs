package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		this.getResult(new ArrayList<Integer>(), result, 0,num, target,0);
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		r.addAll(result);
		return r;
    }
	
	public void getResult(ArrayList<Integer> tmp,Set<List<Integer>> result,int index,int[] num,int target,int sum){
		if(target==sum && !tmp.isEmpty()){
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		if(index>=num.length || sum>target){
			return;
		}
		this.getResult(tmp, result, index+1, num, target, sum);
		tmp.add(num[index]);
		this.getResult(tmp, result, index+1, num, target, sum+num[index]);
		tmp.remove(tmp.size()-1);
	}
	
	public static void main(String[] args){
		CombinationSumII cs = new CombinationSumII();
		int[] num = {10,1,2,7,6,1,5};
		cs.combinationSum2(num, 8);
	}
}
