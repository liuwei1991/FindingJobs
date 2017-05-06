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
		flags = new boolean[nums.length];
		Arrays.sort(nums);
		this.solve(new ArrayList<Integer>(), nums);
		return result;
    }
	
	public void solve(List<Integer> tmp,int[] nums){
		if(tmp.size()==nums.length){
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(this.flags[i] || i>=1 && nums[i-1]==nums[i] && this.flags[i-1]){
				continue;
			}
			this.flags[i] = true;
			tmp.add(nums[i]);
			this.solve(tmp, nums);
			tmp.remove(tmp.size()-1);
			this.flags[i] = false;
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
