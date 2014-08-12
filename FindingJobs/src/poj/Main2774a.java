package poj;

import java.util.Scanner;

public class Main2774a {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int dp[][] = new int[2][s2.length()+1];
		int ans = 0;
		for(int i=1;i<=s1.length();i++){
			for(int j=1;j<=s2.length();j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[1][j] = dp[0][j-1]+1;
					ans = Math.max(ans, dp[1][j]);
				}else{
					dp[1][j] = 0;
				}
			}
			for(int j=0;j<s2.length();j++){
				dp[0][j] = dp[1][j];
			}
		}
		System.out.println(ans);
	}
}
