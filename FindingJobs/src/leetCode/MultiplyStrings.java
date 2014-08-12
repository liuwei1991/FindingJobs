package leetCode;

import java.util.ArrayList;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        ArrayList<Integer> ra = new ArrayList<Integer>();
        int positive = 1;
        
        if(num1.charAt(0)=='-' || num1.charAt(0)=='+'){
        	if(num1.charAt(0)=='-'){
        		positive *= -1;
        	}
        	num1 = num1.substring(1);
        }
        if(num2.charAt(0)=='-' || num2.charAt(0)=='+'){
        	if(num2.charAt(0)=='-'){
        		positive *= -1;
        	}
        	num2 = num2.substring(1);
        }
        
        for(int i=0;i<num1.length();i++){
        	int a = num1.charAt(num1.length()-1-i) - '0';
        	for(int j=0;j<num2.length();j++){
        		int b = num2.charAt(num2.length()-1-j) - '0';
        		if((i+j)>=ra.size()){
        			ra.add(a*b);
        		}else{
        			ra.set(i+j, ra.get(i+j)+a*b);
        		}
        	}
        	for(int k=0;k<ra.size();k++){
        		if(ra.get(k)>=10){
        			if(k+1<ra.size()){
        				ra.set(k+1, ra.get(k+1)+ra.get(k)/10);
        			}else{
        				ra.add(ra.get(k)/10);
        			}
        			ra.set(k, ra.get(k)%10);
        		}
        	}
        }
        
        for(int i = 0;i<ra.size()-1;i++){
        	if(ra.get(ra.size()-1-i)==0){
        		ra.remove(ra.size()-1-i);
        		i--;
        	}else{
        		break;
        	}
        }
        
        char[] t ;
        if(positive == -1){
        	t = new char[ra.size()+1];
        	t[0] = '-';
        	for(int i = 0;i<ra.size();i++){
        		t[1+i] = ra.get(ra.size()-1-i).toString().charAt(0);
        	}
        }else{
        	t = new char[ra.size()];
        	for(int i = 0;i<ra.size();i++){
        		t[i] = ra.get(ra.size()-1-i).toString().charAt(0);
        	}
        }
        
		return String.valueOf(t);
    }
	
	public static void main(String args[]){
		String a = "9913";
		String b = "0";
		MultiplyStrings ms = new MultiplyStrings();
		
		System.out.println(ms.multiply(a, b));
		System.out.println(Integer.valueOf(a)*Integer.valueOf(b));
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Long.MAX_VALUE);
	}
}
