package astart.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	private boolean[] flags;
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		if(nums==null || nums.length==0){
			return result;
		}
		Arrays.sort(nums);
		flags = new boolean[nums.length];
		this.solve(nums, new ArrayList<Integer>(), 0);
		return result;
    }
	
	public void solve(int[] nums, List<Integer> tmp,int level){
		if(level==nums.length){
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(flags[i]||i>=1 && nums[i]==nums[i-1] && flags[i-1]){
				continue;
			}
			flags[i] = true;	
			tmp.add(nums[i]);
			this.solve(nums, tmp, level+1);
			tmp.remove(level);
			flags[i]=false;
		}
	}
	
	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
		int nums[] = {3,1,1};
		List<List<Integer>> result = p.permuteUnique(nums);
		for (List<Integer> a : result) {
			for (int b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
}
