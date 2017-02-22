package astart.leetcode1;

import java.util.List;
import java.util.ArrayList;

public class FindAllNumbersDisappearedinanArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> r = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			while(nums[i]!=i+1 && nums[i]!=-1){
				if(nums[nums[i]-1]==nums[i]){
					nums[i] = -1;
				}else{
					int tmp = nums[nums[i]-1];
					nums[nums[i]-1] = nums[i];
					nums[i]=tmp;
				}
			}
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]==-1){
				r.add(i+1);
			}
		}
		return r;
    }
	
	public static void main(String[] args){
		FindAllNumbersDisappearedinanArray a = new FindAllNumbersDisappearedinanArray();
		int[] nums = {4,3,2,7,8,2,3,1};
		for(int i:a.findDisappearedNumbers(nums)){
			System.out.println(i);
		}
	}
}
