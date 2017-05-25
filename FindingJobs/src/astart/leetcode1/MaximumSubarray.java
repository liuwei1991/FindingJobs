package astart.leetcode1;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = Integer.MIN_VALUE;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				dp[i] = nums[0];
			} else {
				dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}
}
