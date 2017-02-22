package astart.leetcode1;

public class SingleNumber {
	public int singleNumber(int[] nums) {
        int r = 0;
        for(int num:nums){
        	r=r^num;
        }
        return r;
    }
	
	public static void main(String[] args){
		SingleNumber a = new SingleNumber();
		int[] nums = {4,3,2,4,2,3,6};
//		System.out.println(a.singleNumber(nums));
		System.out.println(~0);
		System.out.println(~-1);
		System.out.println(~2);
		System.out.println(~3);
	}
}
