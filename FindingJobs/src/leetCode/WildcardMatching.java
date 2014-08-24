package leetCode;

public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		int i= 0;
		for (i = 0; i < s.length() && i<p.length(); i++) {
			if(s.charAt(i)==p.charAt(i)||p.charAt(i)=='?'){
				continue;
			}else if(p.charAt(i)=='*'){
				return isMatch(s.substring(i),p.substring(i+1)) || isMatch(s.substring(i+1),p.substring(i));
			}else{
				return false;
			}
		}
		if(i<s.length()){
			return false;
		}else if(i<p.length()){
			for(;i<p.length();i++){
				if(p.charAt(i)!='*'){
					return false;
				}
			}
			return true;
		}else{
			return true;
		}
	}

	public static void main(String args[]) {
		WildcardMatching wm = new WildcardMatching();
		 String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
		 String p ="a*******b";
//		String s = "aab";
//		String p = "*a*b*";
		System.out.println(wm.isMatch(s, p));
	}
}
