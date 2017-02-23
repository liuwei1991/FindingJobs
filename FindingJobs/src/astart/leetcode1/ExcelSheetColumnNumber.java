package astart.leetcode1;

public class ExcelSheetColumnNumber {
	//注意String的index 0 在哪里？
	public int titleToNumber(String s) {
        int r = 0;
        int base = 1;
        char[] cs = s.toLowerCase().toCharArray();
        for(int i=cs.length-1;i>=0;i--){
        	r += base*(cs[i]-'a'+1);
        	base*=26;
        }
        return r;
    }
	public static void main(String[] args){
		String tmp = "adsfa";
		for(int i=0;i<tmp.length();i++){
			System.out.println(tmp.charAt(i));
			
		}
	}
}
