package astart.leetcode1;

public class MaxConsecutiveOnes {
	//注意边界问题
	public int findMaxConsecutiveOnes(int[] nums) {
		int r = 0;
		int start = -1;
		if(nums==null || nums.length==0){
			return r;
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]==1 && start==-1){
				start = i;
			}
			if(nums[i]==0 && start!=-1){
				r = Math.max(r, i-start);
				start = -1;
			}
		}
		if(nums[nums.length-1]==1){
			r = Math.max(r, nums.length-1-start+1);
		}
		return r;
	}
}
