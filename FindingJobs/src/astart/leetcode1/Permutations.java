package astart.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	private boolean flags[];

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return result;
		}
		flags = new boolean[nums.length];
		Arrays.sort(nums);
		this.solve(nums, new ArrayList<Integer>(), 0);
		return this.result;
	}

	public void solve(int nums[], List<Integer> sequence, int level) {
		if (level == nums.length) {
			result.add(new ArrayList<Integer>(sequence));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (flags[i] || i != 0 && nums[i] == nums[i - 1] && flags[i - 1]) {
				continue;
			}
			flags[i] = true;
			sequence.add(nums[i]);
			this.solve(nums, sequence, level+1);
			flags[i] = false;
			sequence.remove(level);
		}
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int nums[] = {3,1,1};
		List<List<Integer>> result = p.permute(nums);
		for (List<Integer> a : result) {
			for (int b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
}
