package astart.leetcode1;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for(int i=0;i<nums.length;i++){
        	int curNum = nums[i];
        	if(nums[i]!=0){
        		nums[i]=0;
        		nums[zeroIndex]=curNum;
        		zeroIndex+=1;
        	}
        }
    }
}
