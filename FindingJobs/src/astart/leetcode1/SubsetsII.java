package astart.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums==null||nums.length==0){
			return result;
		}
		Arrays.sort(nums);
		this.solve(new ArrayList<Integer>(), nums, 0);
		return result;
    }
	
	private void solve(List<Integer> tmp,int[] nums,int level){
		result.add(new ArrayList<Integer>(tmp));
		
		for(int i=level;i<nums.length;i++){
			tmp.add(nums[i]);
			this.solve(tmp, nums, i+1);
			tmp.remove(tmp.size()-1);
			while(i<nums.length-1 && nums[i+1]==nums[i]){
				i++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		SubsetsII s = new SubsetsII();
		int[] nums = {1,2,2};
		List<List<Integer>> result = s.subsetsWithDup(nums);
		System.out.println(result.size());
		for (List<Integer> a : result) {
			for (int b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}

}
