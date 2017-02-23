package astart.leetcode1;

public class MinimumMovestoEqualArrayElements {
	public int minMoves(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
        int min = nums[0];
        for(int num:nums){
        	min = Math.min(min, num);
        }
        int r = 0;
        for(int num:nums){
        	r+=num-min;
        }
        return r;
    }
}
