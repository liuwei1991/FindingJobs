package astart.leetcode1;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if(nums==null){
			return 0;
		}
		if(nums.length<=1){
			return nums.length;
		}
        int result = 0;
        int cur = nums[0];
        for(int i=1;i<nums.length;i++){
        	while(i<nums.length&& nums[i]==cur ){
        		i++;
        	}
        	if(i<nums.length){
        		cur = nums[i];
        		result+=1;
        		nums[result] = cur;
        	}
        }
        return result+1;
    }
	
	public static void main(String[] args){
		RemoveDuplicatesfromSortedArray rd = new RemoveDuplicatesfromSortedArray();
		int nums[] = {1,1};
		int a = rd.removeDuplicates(nums);
		System.out.println(a);
		for(int i:nums){
			System.out.print(i+",");
		}
	}
}
