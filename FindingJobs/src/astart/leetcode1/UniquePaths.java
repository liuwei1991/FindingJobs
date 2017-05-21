package astart.leetcode1;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0 || m+n==1){
        	return 0;
        }
        if(m==1||n==1){
        	return 1;
        }
        int result = this.getCMN(m+n-2, n-1);
        return result;
	}
	public int getCMN(int m,int n){
		if(m==0||n==0){
			return 1;
		}
		if(n>m/2){
			return this.getCMN(m, m-n);
		}
		int result = 1;
		for(int i=1;i<=n;i++){
			int a = this.gcd(result, i);
			result = result/a;
			result *=(m-i+1);
			result /= i/a;
		}
		return result;
	}
	
	public int gcd(int a,int b){
		if(b==0){
			return a;
		}
		return gcd(b,a%b);
	}
	
	public static void main(String[] args){
		UniquePaths up = new UniquePaths();
		int m = 2;
		int n = 100;
		System.out.println(up.uniquePaths(m, n));
	}
}
