package poj;

import java.util.Scanner;

public class Main2533 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		for(int i=0;i<n;i++){
			s[i] = sc.nextInt();
		}
		int[] dp = new int[n];
		for(int i=0;i<n;i++){
			dp[i] = 1;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(s[i]>s[j]){
					dp[i]=dp[i]>(dp[j]+1)?dp[i]:dp[j]+1;
				}
			}
		}
		int max = 0;
		for(int i=0;i<n;i++){
			if(max<dp[i]){
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
