package astart.leetcode1;

public class ReverseWordsinaStringIII {
	public String reverseWords(String s) {
        String[] ss = s.split(" ");
        String result = "";
        for(int i=0;i<ss.length;i++){
        	result += this.reverse(ss[i])+" ";
        }
        return result.trim();
    }
	
	public String reverse(String s){
		char[] cs = s.toCharArray();
		for(int i=0;i<cs.length/2;i++){
			char tmp = cs[i];
			cs[i] = cs[cs.length-1-i];
			cs[cs.length-1-i] = tmp;
		}
		return String.valueOf(cs);
	}
	
	public static void main(String[] args){
		ReverseWordsinaStringIII rs = new ReverseWordsinaStringIII();
		String s = "Let's take LeetCode contest";
		System.out.println(rs.reverseWords(s));
	}
}
