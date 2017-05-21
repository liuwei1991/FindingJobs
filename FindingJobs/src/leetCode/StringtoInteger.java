package leetCode;

public class StringtoInteger {
	public int atoi(String str) {
		if(str==null || str.length()==0){
			return 0;
		}
		str = str.trim();
		boolean positive = true;
		int i = 0;
		if(str.charAt(0)=='-'){
			positive = false;
			i++;
		}
		if(str.charAt(0)=='+'){
			i++;
		}
		double result = 0.0;
		for(;i<str.length()&&str.charAt(i)>='0' && str.charAt(i)<='9';i++){
			result = result*10+str.charAt(i)-'0';
			if(result>(Integer.MAX_VALUE+1.0)){
				break;
			}
		}
		if(positive){
			if(result>Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}
		}else{
			if(result>(-1.0*Integer.MIN_VALUE)){
				return Integer.MIN_VALUE;
			}
			result = -result;
		}
		return (int)result;
	}
	
	public static void main(String[] args){
		String str = "";
		StringtoInteger si = new StringtoInteger();
		System.out.println(si.atoi(str));
	}
}
