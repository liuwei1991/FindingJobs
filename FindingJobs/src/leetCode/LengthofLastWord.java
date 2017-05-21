package leetCode;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if(s==null || s.length()==0) return 0;
		if(s.split(" ").length==0) return 0;
		return s.split(" ")[s.split(" ").length-1].length();
    }
	
	public static void main(String[] args){
		LengthofLastWord ll = new LengthofLastWord();
		String s = "  ";
		System.out.println(ll.lengthOfLastWord(s));
	}
}
