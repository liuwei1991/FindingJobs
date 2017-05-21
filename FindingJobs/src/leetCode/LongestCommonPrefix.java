package leetCode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0){
			return "";
		}
		if(strs.length==1){
			return strs[0];
		}
		String result = strs[0];
		for(int i=1;i<strs.length;i++){
			result = this.commonPrefix(result, strs[i]);
		}
		return result;
    }
	public String commonPrefix(String a,String b){
		String result = "";
		for(int i=0;i<a.length() && i<b.length();i++){
			if(a.charAt(i)==b.charAt(i)){
				result += a.charAt(i);
			}else{
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = {"aca","cba"};
		System.out.println(lcp.longestCommonPrefix(strs));
	}
}
