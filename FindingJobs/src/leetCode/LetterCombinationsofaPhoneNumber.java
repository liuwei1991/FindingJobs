package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	private char[][] phone = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
			{ 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
			{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		this.solve(result, "", 0, digits);
		return result;
	}

	public void solve(List<String> result, String tmp, int start, String digits) {
		if (start == digits.length()) {
			result.add(tmp);
			return;
		}
		int button = digits.charAt(start) - '0';
		if (button >= 2 && button <= 6 || button == 8) {
			this.solve(result, tmp + phone[button][0], start + 1, digits);
			this.solve(result, tmp + phone[button][1], start + 1, digits);
			this.solve(result, tmp + phone[button][2], start + 1, digits);
		} else if (button == 7 || button == 9) {
			this.solve(result, tmp + phone[button][0], start + 1, digits);
			this.solve(result, tmp + phone[button][1], start + 1, digits);
			this.solve(result, tmp + phone[button][2], start + 1, digits);
			this.solve(result, tmp + phone[button][3], start + 1, digits);
		} else {
			this.solve(result, tmp, start + 1, digits);
		}
	}
	public static void main(String[] args){
		LetterCombinationsofaPhoneNumber lc = new LetterCombinationsofaPhoneNumber();
		String s ="2342";
		lc.letterCombinations(s);
	}
}
