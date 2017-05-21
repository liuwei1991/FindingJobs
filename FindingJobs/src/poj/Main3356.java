package poj;

import java.util.Scanner;

public class Main3356 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x = sc.nextInt();
			String s1 = sc.next();
			int y = sc.nextInt();
			String s2 = sc.next();
			if(x==0 || y==0){
				System.out.println(Math.max(x, y));
				return;
			}
			int dp[][] = new int[x+1][y+1];
			for(int i=0;i<=x;i++){
				dp[i][0] = i;
			}
			for(int i=0;i<=y;i++){
				dp[0][i] = i;
			}
			
			for(int i=1;i<=x;i++){
				for(int j=1;j<=y;j++){
					if(s1.charAt(i-1) == s2.charAt(j-1)){
						dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1),dp[i-1][j-1]);
					}else{
						dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1),dp[i-1][j-1]+1);
					}
				}
			}
			System.out.println(dp[x][y]);
		}
	}
}
