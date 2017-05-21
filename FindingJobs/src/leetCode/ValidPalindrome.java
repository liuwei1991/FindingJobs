package leetCode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		s = s.toLowerCase();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='A' && s.charAt(i)<='Z'
					||s.charAt(i)>='0' && s.charAt(i)<='9'){
				sb.append(s.charAt(i));
			}
		}
		String tmp = sb.toString();
		for(int i=0;i<tmp.length()/2;i++){
			if(tmp.charAt(i)!=tmp.charAt(tmp.length()-1-i)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		ValidPalindrome vp = new ValidPalindrome();
		String s = "0k.;r0.k;";
		System.out.println(vp.isPalindrome(s));
	}
}
