package astart.leetcode1;

public class DetectCapital {
	public boolean detectCapitalUse(String word) {
        char[] cs = word.toCharArray();
        boolean canUpper = false;
        for(int i=0;i<cs.length;i++){
        	if(i==0){
        		if(cs[i]>='A' && cs[i]<='Z'){
        			canUpper = true;
        		}
        	}else{
        		if(cs[i]>='A' && cs[i]<='Z'){
        			if(!canUpper){
        				return false;
        			}
        		}
        		if(cs[i]>='a' && cs[i]<='z'){
        			if(i==1){
        				canUpper = false;
        			}else if(canUpper){
        				return false;
        			}
        		}
        	}
        }
        return true;
    }
	
	public static void main(String[] args){
		DetectCapital dc = new DetectCapital();
		String word = "Leetcode";
		System.out.println(dc.detectCapitalUse(word));
	}
}
