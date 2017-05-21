package poj;

import java.util.Scanner;

public class Main3624 {
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int w[] = new int[n];
		int d[] = new int[n];
	
		for(int i=0;i<n;i++){
			w[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		sc.close();
		int dp[] = new int[m+1];
		for(int i=0;i<m+1;i++){
			dp[i] = 0;
		}
		for(int i=0;i<n;i++){
			for(int j=m;j>=w[i];j--){
				dp[j] = dp[j]>(dp[j-w[i]]+d[i])?dp[j]:dp[j-w[i]]+d[i];
			}
		}
		System.out.println(dp[m]);
	}
}
