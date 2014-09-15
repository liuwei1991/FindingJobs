package leetcode2;

public class PalindromePartitioningII {
	public int minCut(String s) {
		if(s==null||s.length()==0){
			return 0;
		}
		int[][] dp = new int[s.length()+1][s.length()+1];
		for(int i=0;i<s.length()+1;i++){
			for(int j=0;j<s.length()+1;j++){
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int m = 1;m<=s.length();m++){
			for(int i=0;i+m<=s.length();i++){
				if(isPaline(s.substring(i, i+m))){
					dp[i][i+m] = 0;
					continue;
				}
				for(int k=i+1;k<i+m;k++){
					dp[i][i+m] = Math.min(dp[i][i+m],dp[i][k]+1+dp[k][i+m]);
				}
			}
		}
		return dp[0][s.length()];
    }
	
	private boolean isPaline(String str){
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-1-i)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		PalindromePartitioningII pp = new PalindromePartitioningII();
		String s = "aabaac";
		System.out.println(pp.minCut(s));
	}
}
