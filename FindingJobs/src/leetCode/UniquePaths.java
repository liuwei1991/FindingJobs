package leetCode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {

//		return C(m+n-2,n-1);
		if(m==1 || n ==1) return 1;
		int dp[][] = new int[m+1][n+1];
		dp[1][1]=1;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(i==1 && j==1) continue;
				dp[i][j]=dp[i-1][j] +dp[i][j-1];
			}
		}
		return dp[m][n];
    }
	
	public int gcd(int a, int b){
		if(b==0) return a;
		return gcd(b,a%b);
	}
	public int C(int m,int n){
		int result = 1;
		n = Math.min(m-n, n);
		for(int i=1;i<=n;i++){
			int div = gcd(i,m+1-i);
			int up = (m+1-i)/div;
			int down = i/div;
			result/=down;
			result*=up;
		}
		return result;
	}
	public static void main(String[] args){
		UniquePaths up = new UniquePaths();
		System.out.print(up.uniquePaths(2, 3));
	}
}
