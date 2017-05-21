package leetCode;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length()){
			return false;
		}
		boolean f[][] = new boolean[s1.length()+1][s2.length()+1];
		 f[0][0] = true;
		 for(int i = 1; i <= s1.length(); i++)
			 f[i][0] = f[i-1][0] && (s3.charAt(i-1) == s1.charAt(i-1));
		 
		 for(int j = 1; j <= s2.length(); j++)
			 f[0][j] = f[0][j-1] && (s3.charAt(j-1) == s2.charAt(j-1));
		 
		 for(int i = 1; i <= s1.length(); i++)
			 for(int j = 1; j <= s2.length(); j++)
				 f[i][j] = (f[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (f[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
		return f[s1.length()][s2.length()];
    }
		
	public static void main(String[] args){
		InterleavingString is = new InterleavingString();
//		String s1 = "aabcc";
//		String s2 = "dbbca";
//		String s3 = "aadbbcbcac";
//		String s3 = "aadbbbaccc";
		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
//		String s1 = "";
//		String s2 = "b";
//		String s3 = "b";
		System.out.println(is.isInterleave(s1, s2, s3));
	}
}
