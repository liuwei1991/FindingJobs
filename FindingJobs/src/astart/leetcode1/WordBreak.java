package astart.leetcode1;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
//		 return this.solve(s, 0, wordDict);
		return this.solve2(s, wordDict);
	}

	public boolean solve(String s, int start, List<String> wordDict) {
		if (start == s.length()) {
			return true;
		}
		for (String word : wordDict) {
			if (start + word.length() <= s.length()) {
				if (s.substring(start, start + word.length()).equals(word)) {
					if (this.solve(s, start + word.length(), wordDict)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean solve2(String s, List<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null) {
			return true;
		}
		boolean flag[] = new boolean[s.length() + 1];
		flag[0] = true;
		for (int i = 0; i < s.length(); i++) {
			for (String word : wordDict) {
				if (flag[i] && i+word.length()<=s.length() ) {
					if(s.substring(i, i+word.length()).equals(word)){
//						System.out.println(s.substring(i, i+word.length()));
//						System.out.println(word);
						flag[i + word.length()] = true;
					}
				}
			}
		}
		return flag[s.length()];
	}

	public static void main(String[] args) {
//		String s = "112asdsfasd";
		String s = "leetcode";
		String[] dict = {"leet", "code"};
		WordBreak wb = new WordBreak();
		System.out.println(wb.solve2(s,Arrays.asList(dict)));

//		System.out.println(s.substring(0, 300));
	}
}
