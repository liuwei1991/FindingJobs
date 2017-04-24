package astart.leetcode1;

import java.util.Arrays;

public class nextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int a1 = -1;
		int a2 = -1;
		for (a1 = nums.length - 2; a1 >= 0; a1--) {
			if (nums[a1] < nums[a1 + 1]) {
				break;
			}
		}
		if (a1 == -1) {
			Arrays.sort(nums);
			return;
		}
		for (a2 = nums.length - 1; a2 >= 0; a2--) {
			if (nums[a2] > nums[a1]) {
				break;
			}
		}
		int tmp = nums[a1];
		nums[a1] = nums[a2];
		nums[a2] = tmp;
		Arrays.sort(nums,a1+1,nums.length);
	}

	public static void main(String[] args){
		nextPermutation np = new nextPermutation();
		int[] nums = {1,1,2};
//		Arrays.sort(nums,2,nums.length);
		np.nextPermutation(nums);
		for(int i:nums){
			System.out.println(i);
		}
	}
}
