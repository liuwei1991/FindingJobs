package leetCode;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(s==null ||s.length()<=1||nRows==1){
			return s;
		}
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        
        for(int i=0;i*2*(nRows-1)<length;i++){
        	sb.append(s.charAt(i*2*(nRows-1)));
        }
        
        for(int r=1;r<nRows-1;r++){
        	for(int i=0;;i++){
        		int index;
        		if(i==0){
        			index = r;
        			if(index<length){
        				sb.append(s.charAt(r));
        			}else{
        				break;
        			}
        		}else{
        			index = i*2*(nRows-1)-r;
        			if(index<length){
        				sb.append(s.charAt(index));
        			}else{
        				break;
        			}
        			index = i*2*(nRows-1)+r;
        			if(index<length){
        				sb.append(s.charAt(index));
        			}else{
        				break;
        			}
        		}
        	}
        }
        for(int i=0;(i*2*(nRows-1)+(nRows-1))<length;i++){
        	sb.append(s.charAt(i*2*(nRows-1)+(nRows-1)));
        }
        return sb.toString();
    }
	public static void main(String[] args){
		ZigZagConversion zz = new ZigZagConversion();
		String s = "12";
		int nRows = 1;
		System.out.println(zz.convert(s, nRows));
	}
}
