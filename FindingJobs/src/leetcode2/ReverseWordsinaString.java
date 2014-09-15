package leetcode2;

public class ReverseWordsinaString {
	 public String reverseWords(String s) {
		 String[] sts = s.split("[ ]+");
		 StringBuffer sb = new StringBuffer();
		 for(int i= sts.length-1;i>=0;i--){
			 sb.append(" "+sts[i]);
		 }
		 return sb.toString().trim();
	 }
}
