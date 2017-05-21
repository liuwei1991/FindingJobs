package leetCode;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if(s1==null ||s2==null || s1.length()!=s2.length()){
			return false;
		}
		if(s1.length()==0 && s2.length()==0){
			return true;
		}
        boolean dp[][][] = new boolean[s1.length()][s1.length()][s1.length()+1];
        
        for(int i=0;i<s1.length();i++){
        	for(int j=0;j<s1.length();j++){
        		if(s1.charAt(i)==s2.charAt(j)){
        			dp[i][j][1]=true;
        		}
        	}
        }
        
        for(int l=2;l<=s1.length();l++){
        	for(int i=0;(i+l)<=s1.length();i++){
        		for(int j=0;(j+l)<=s1.length();j++){
        			for(int k=1;k<l;k++){
        				dp[i][j][l] = dp[i][j][l]
        						|| dp[i][j][k]&&dp[i+k][j+k][l-k]
        						|| dp[i][j+k][l-k] && dp[i+l-k][j][k];
        						
        			}
        		}
        	}
        }
        return dp[0][0][s1.length()];
	}
	public static void main(String[] args){
		ScrambleString sc = new ScrambleString();
		String s1= "great";
		String s2= "rgeat";
		System.out.println(sc.isScramble(s1, s2));
	}
}
