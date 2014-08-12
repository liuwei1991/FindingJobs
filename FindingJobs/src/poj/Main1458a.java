package poj;

import java.util.Scanner;

public class Main1458a {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s1 = sc.next();
			String s2 = sc.next();
			int dp[][] = new int[s1.length()+1][s2.length()+1];
			for(int i=1;i<=s1.length();i++){
				for(int j=1;j<=s2.length();j++){
					if(s1.charAt(i-1) == s2.charAt(j-1)){
						dp[i][j] = dp[i-1][j-1]+1;
					}else{
						dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
					}
				}
			}
			System.out.println(dp[s1.length()][s2.length()]);
		}
	}
}
