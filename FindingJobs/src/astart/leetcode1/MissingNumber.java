package astart.leetcode1;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while(nums[i]!=i){
				if(nums[i]>=nums.length){
					break;
				}
				int tmp = nums[i];
				if(tmp == nums[tmp]){
					break;
				}
				nums[i] = nums[tmp];
				nums[tmp] = tmp;
			}
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=i){
				return i;
			}
		}
		return nums.length;
	}
	
	public static void main(String[] args){
		MissingNumber mn = new MissingNumber();
		int[] nums = {1,0};
		mn.missingNumber(nums);
	}
}
