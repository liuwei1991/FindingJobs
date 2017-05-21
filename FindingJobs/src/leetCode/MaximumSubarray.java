package leetCode;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if(A==null) return 0;
		if(A.length==0) return 0;
		int dp[] = new int[A.length + 1];
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			dp[i+1] = Math.max(dp[i]+A[i], A[i]);
			if(dp[i+1]>ans){
				ans = dp[i+1];
			}
		}
		return ans;
	}
	
	public static void main(String[] args){
		MaximumSubarray ms = new MaximumSubarray();
		int[] a = {};
		System.out.println(ms.maxSubArray(a));
	}
}
