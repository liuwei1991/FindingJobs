package poj;

import java.util.Scanner;

public class Main1384 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int v = -sc.nextInt() + sc.nextInt();
			int n = sc.nextInt();
			int[] p = new int[n];
			int[] w = new int[n];
			for(int j=0;j<n;j++){
				p[j] = sc.nextInt();
				w[j] = sc.nextInt();
			}
			
			int[] dp = new int[v+1];
			
			for(int j=1;j<v+1;j++){
				dp[j] = Integer.MAX_VALUE/2;
			}
			for(int j=0;j<n;j++){
				for(int k=w[j];k<=v;k++){
					dp[k] = dp[k]<(dp[k-w[j]]+p[j])?dp[k]:dp[k-w[j]]+p[j];
				}
			}
			if(dp[v]<(Integer.MAX_VALUE/2-1)){
				System.out.printf("The minimum amount of money in the piggy-bank is %d.\n", dp[v]);
			}else{
				System.out.println("This is impossible.");
			}
		}
	}
}
