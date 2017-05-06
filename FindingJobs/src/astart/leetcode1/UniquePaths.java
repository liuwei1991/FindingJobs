package astart.leetcode1;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0 || m+n==1){
        	return 0;
        }
        int c = m-1+n-1;
        int result = 1;
        for(int i=1;i<=n-1;i++){
        	result = result* (c-i+1)/i;
        }
        return result;
	}
}
