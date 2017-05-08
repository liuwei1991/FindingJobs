package astart.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null||candidates.length==0){
        	return result;
        }
        Arrays.sort(candidates);
        this.solve(candidates, 0, 0, target, new ArrayList<Integer>());
        return result;
    }
	
	public void solve(int[] nums,int start ,int sum,int target,List<Integer> tmp){
		if(sum==target){
			result.add(new ArrayList<Integer>(tmp));
			return ;
		}else if(sum>target){
			return;
		}
		for(int i=start;i<nums.length;i++){
			tmp.add(nums[i]);
			this.solve(nums, i+1,sum+nums[i],target, tmp);
			tmp.remove(tmp.size()-1);
			while(i<nums.length-1 && nums[i]==nums[i+1]){
				i++;
			}
		}
	}
}
