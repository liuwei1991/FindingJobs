package leetCode;

public class WildcardMatching {

	
	public boolean isMatch(String s, String p) {
        int count =0;  
        for(int i=0;i<p.length();i++){  
            if(p.charAt(i)!='*')  
                count++;  
        }  
        if(count>s.length())  
            return false;  
        boolean dp[][] = new boolean[500][500];  
        dp[0][0]=true;  
        for(int i=0;i<p.length();i++){  
            if(dp[0][i]&&p.charAt(i)=='*')  
                dp[0][i+1]=true;  
            for(int j=0;j<s.length();j++){  
                if(p.charAt(i)=='*')  
                    dp[j+1][i+1]=(dp[j][i+1]||dp[j+1][i]);  
                else if(p.charAt(i)=='?'||s.charAt(j)==p.charAt(i))  
                    dp[j+1][i+1]=dp[j][i];  
                else  
                    dp[j+1][i+1]=false;  
            }  
        }  
        return dp[s.length()][p.length()];  
    }
	
	public boolean isMatch1(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		int count = 0;
		
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
