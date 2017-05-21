package leetCode;

public class ReverseWordsinaString {
	public class Solution {
	    public String reverseWords(String s) {
	        String tmp[] = s.split(" ");
	        StringBuilder sb =  new StringBuilder();
	        for(int i=tmp.length;i>1;i--){
	        	sb.append(tmp[i-1]+" ");
	        }
	        sb.append(tmp[0]);
	    	return sb.toString();
	    }
	}
	
	public static void main(String[] args){
		ReverseWordsinaString rws = new ReverseWordsinaString();
		Solution d = rws.new Solution();
		String str = "a  b";
		System.out.println(str.split("( )+")[0]);

		System.out.print(str.split("( )+")[1]);
		
//		System.out.println(d.reverseWords(str));
	}
}
