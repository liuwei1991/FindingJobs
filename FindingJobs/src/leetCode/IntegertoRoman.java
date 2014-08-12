package leetCode;

public class IntegertoRoman {
	public char[] mark ={'I','V','X','L','C','D','M'};
	
	public String intToRoman(int num) {
		int count=0;
		String result = "";
		while(num!=0){
			int a = num%10;
			String tmp = "";
			if(count%2==1){
				if(a>=1 && a<=3){
					for(int i=0;i<a;i++){
						tmp+=mark[count+1];
					}
				}else if(a==4){
					tmp+=mark[count+1]+""+mark[count+2];
				}else if(a>=5 && a<=8){
					tmp += mark[count+2];
					for(int i=6;i<=a;i++){
						tmp+=mark[count+1];
					}
				}else if(a==9){
					tmp+=mark[count+1]+""+mark[count+3];
				}
			}else{
				if(a>=1 && a<=3){
					for(int i=0;i<a;i++){
						tmp+=mark[count];
					}
				}else if(a==4){
					tmp+=mark[count]+""+mark[count+1];
				}else if(a>=5 && a<=8){
					tmp += mark[count+1];
					for(int i=6;i<=a;i++){
						tmp+=mark[count];
					}
				}else if(a==9){
					tmp+=mark[count]+""+mark[count+2];
				}
				count++;
			}
			result = tmp+result;
			count++;
			num/=10;
		}
        return result;
    }
	
	public static void main(String[] args){
		IntegertoRoman ir = new IntegertoRoman();
//		System.out.println(ir.intToRoman(123));
		System.out.println(ir.intToRoman(10));
	}
}
