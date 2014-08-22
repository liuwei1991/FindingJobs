package leetCode;

public class DecodeWays {
	int num[];
	
	public int numDecodings(String s) {
		num = new int[s.length()];
		return this.getResult(s,0);
    }
	
	private int getResult(String ss,int i){
		String s = ss.substring(i);
		if(s==null||s.length()==0||s.charAt(0)=='0'){
			return 0;
		}
		if(s.length()==1){
			num[i] = 1;
			return 1;
		}
		if(s.charAt(1)=='0'){
			if(s.charAt(0)>'2'){
				return 0;
			}
			if((i+2)>=ss.length()){
				num[i] = 1;
			}else if(num[i+2]==0){
				num[i+2] = this.getResult(ss, i+2);
				num[i]=num[i+2];
			}
			return num[i];
		}else if(s.charAt(0)=='1' || s.charAt(0)=='2' && s.charAt(1)<'7'){
			if((i+2)>=ss.length()){
				num[i+1]=1;
				num[i] = 2;
			}else{
				if(num[i+1]==0){
					num[i+1] = this.getResult(ss, i+1);
				}
				if(num[i+2]==0){
					num[i+2] = this.getResult(ss, i+2);
				}
				num[i] = num[i+1]+num[i+2];
			}
			return num[i];
		}else{
			if(num[i+1]==0){
				num[i+1] = this.getResult(ss,i+1);
			}
			num[i]=num[i+1];
			return num[i];
		}
	}
	
	public static void main(String[] args){
		DecodeWays dw = new DecodeWays();
		String s = "230";
		System.out.println(dw.numDecodings(s));
	}
}
