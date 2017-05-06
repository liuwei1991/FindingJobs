package astart.leetcode1;

public class Palindrome {
	public boolean isPalindrome(int x) {
		if(x<0){
			x=-x;
		}
		int base = 1;
		int tmpx = x;
		while(tmpx>=10){
			base *= 10;
			tmpx/=10;
		}
		while(base>=10){
			int high = x/base;
			int low = x%10;
			if(high!=low){
				return false;
			}
			x=x%base;
			x=x/10;
			base/=100;
		}
		return true;
	}
	public static void main(String[] args){
		Palindrome p = new Palindrome();
		System.out.println(p.isPalindrome(1000021));
	}
}
