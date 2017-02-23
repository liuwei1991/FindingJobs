package astart.leetcode1;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0){
        	return 0;
        }
        int start = 0;
        int end = nums.length-1;
        if(nums[start]>=target){
        	return 0;
        }
        if(nums[end]<target){
        	return end+1;
        }
        while(start<=end){
        	int mid = (start+end)/2;
        	if(nums[mid]==target){
        		return mid;
        	}else if(nums[mid]<target){
        		start = mid+1;
        	}else{
        		end = mid-1;
        	}
        }
        if(nums[start]<target){
        	return start+1;
        }
        if(nums[end]>target){
        	return end;
        }
        return end+1;
    }
	public static void main(String[] args){
		SearchInsertPosition si = new SearchInsertPosition();
		int[] nums = {1,3,5};
		int target = 2;
		System.out.println(si.searchInsert(nums, target));
	}
}
