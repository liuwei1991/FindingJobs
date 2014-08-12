package leetCode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() == 0)
			return s;
		if (s == null)
			return s;
		boolean dp[][] = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = true;
			}
		}
		int longest = 1;
		String ans = s.substring(0, 1);
		
		//注意循环，最外层循环应该是步数，内层循环是开始的节点
		for (int k = 1; k < s.length(); k++) {
			for (int i = 0; i+k < s.length(); i++) {
				int j=i+k;
				if (s.charAt(i) == s.charAt(j)) {
					if (i == s.length() - 1 || j == 0) {
						dp[i][j] = true;
					} else if (dp[i + 1][j - 1]) {
						dp[i][j] = true;
					}
				}
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (dp[i][j] && j - i + 1 > longest) {
					ans = s.substring(i, j + 1);
					longest = j - i + 1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("aaaa"));
	}
}
