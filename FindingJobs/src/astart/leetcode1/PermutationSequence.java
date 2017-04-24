package astart.leetcode1;

import java.util.Arrays;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if(n<=0){
			return ""; 
		}
		if(n==1){
			return "1";
		}
        int nums[] = new int[n];
        for(int i=1;i<=n;i++){
        	nums[i-1] = i;
        }
        String result = "";
        k = k-1;
        for(int i=n-1;i>=1;i--){
        	int jie = this.getJieC(i);
        	int m = k/jie;
        	k = k%jie;
        	result += nums[m];
        	nums[m] = Integer.MAX_VALUE;
        	Arrays.sort(nums);
        }
        result += nums[0];
        return result;
    }
	
	public int getJieC(int n){
		int result = 1;
		for(int i=1;i<=n;i++){
			result *= i;
		}
		return result;
	}
	public static void main(String[] args){
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(3, 6));
	}
}
