package astart.leetcode1;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
			int[] r = new int[findNums.length];
			for(int i=0;i<findNums.length;i++){
				boolean start = false;
				boolean find = false;
				for(int j=0;j<nums.length;j++){
					if(!start && nums[j]!=findNums[i]){
						continue;
					}else if(nums[j]==findNums[i]){
						start=true;
					}else if(nums[j]>findNums[i]){
						r[i]=nums[j];
						find = true;
						break;
					}
				}
				if(!find){
					r[i]=-1;
				}
			}
			return r;
	  }
}
