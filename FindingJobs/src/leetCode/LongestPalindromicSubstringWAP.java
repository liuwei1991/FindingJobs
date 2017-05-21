package leetCode;

public class LongestPalindromicSubstringWAP {
	public String longestPalindrome(String s) {
		if (s == null) {
			return s;
		}
		if (s.length() == 0) {
			return s;
		}
		boolean dp[][] = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = true;
			}
		}
		int maxLen = 1;
		String palindrome = s.substring(0, 1);
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; i + j < s.length(); j++) {
				int k = i+j;
				if (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1]) {
					dp[j][k] = true;
					if(i+1>maxLen){
						maxLen = i+1;
						palindrome = s.substring(j,i+j+1);
					}
				}
			}
		}
		return palindrome;
	}
	public static void main(String[] args){
		LongestPalindromicSubstringWAP lps = new LongestPalindromicSubstringWAP();
		String s = "aa";
		System.out.println(lps.longestPalindrome(s));
	}
}
