package leetCode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		int big=1;
		int small=10;
		int tmp = x;
		int length = 1;
		while(tmp/10!=0){
			tmp=tmp/10;
			length++;
			big*=10;
		}
		for(int i=0;i<length/2;i++){
			if(x/big != x%small){
				return false;
			}
			x=x%big;
			x=x/small;
			big/=100;
		}
		return true;
    }
	
	public static void main(String[] args){
		PalindromeNumber pn = new PalindromeNumber();
		int x = 00;
		System.out.println(pn.isPalindrome(x));
	}
}
