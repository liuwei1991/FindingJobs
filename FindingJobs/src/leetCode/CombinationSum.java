package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this.getResult(result, new ArrayList<Integer>(), candidates, target, 0);
		return result;
    }
	
	public void getResult(List<List<Integer>> result,List<Integer> tmp, int[] can,int target,int start){
		if(start>=can.length){
			return;
		}
		int item = can[start];
		this.getResult(result, tmp, can, target, start+1);
		int i;
		for(i=1;i<=target/item;i++){
			tmp.add(item);
			if(target-i*item == 0){
				result.add(new ArrayList<>(tmp));
			}else{
				this.getResult(result, tmp, can, target-i*item, start+1);
			}
		}
		while(i>1){
			tmp.remove(tmp.size()-1);
			i--;
		}
	}
	public static void main(String[] args){
		CombinationSum cs = new CombinationSum();
		int[] candidates = {2,3,6,7};
		int target = 7;
		cs.combinationSum(candidates, target);
	}
}
