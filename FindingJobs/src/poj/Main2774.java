package poj;

import java.util.Scanner;

public class Main2774 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();
		int dp[][] = new int[ca.length+1][cb.length+1];
		int max = 0;
		for(int i=1;i<=ca.length;i++){
			for(int j=1;j<=cb.length;j++){
				if(ca[i-1] == cb[j-1]){
					dp[i][j]=dp[i-1][j-1]+1;
					if(max<dp[i][j]){
						max = dp[i][j];
					}
				}
			}
		}
		System.out.println(max);
	}
}
