package astart.leetcode1;

public class ReverseString {
	public String reverseString(String s) {
        char[] cs = s.toCharArray(); 
        char[] r = new char[(s.toCharArray()).length];
        for(int i=cs.length-1;i>=0;i--){
        	r[cs.length-i-1] = cs[i];
        }
        return String.valueOf(r);
    }
}
