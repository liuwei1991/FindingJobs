package leetCode;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if(s==null || p==null){
			return false;
		}
		return match(s.toCharArray(),0,p.toCharArray(),0);
	}
	
	private boolean match(char[] s,int s1,char[] p,int s2){
		if(s2>=p.length){
			return s1==s.length;
		}
		if((s2+1)<p.length && p[s2+1]=='*'){
			while(s1<s.length && (s[s1]==p[s2]||p[s2]=='.')){
				if(match(s,s1,p,s2+2)){
					return true;
				}
				s1++;
			}
			return match(s,s1,p,s2+2);
		}else{
			if(s1<s.length && (s[s1]==p[s2] ||p[s2]=='.')){
				return match(s,s1+1,p,s2+1);
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		RegularExpressionMatching re = new RegularExpressionMatching();
		String s = "aa";
		String p = "a";
		System.out.println(re.isMatch(s, p));
	}
}
