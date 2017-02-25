package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddStrings {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carray = 0;
		for(int i =num1.length()-1,j = num2.length()-1;i>=0||j>=0;i--,j--){
			char a1='0';
			char a2='0';
			if(i<0 && j<0){
				break;
			}else if(i<0){
				a1 = '0';
				a2 = num2.charAt(j);
			}else if(j<0){
				a1 = num1.charAt(i);
				a2 = '0';
			}else{
				a1 = num1.charAt(i);
				a2 = num2.charAt(j);
			}
			if(a1+a2+carray-'0'-'0'>=10){
				sb = sb.append((char)(a1+a2+carray-'0'-10));
				carray = 1;
			}else{
				sb.append((char)(a1+a2+carray-'0'));
				carray = 0;
			}
		}
		if(carray==1){
			sb.append('1');
		}
		return sb.reverse().toString();
	}
	
	
	public String addStrings1(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        int increase = 0;
        Stack<Character> result = new Stack<Character>();
        int i = s1.length-1;
        int j = s2.length-1;
        for(i=s1.length-1,j=s2.length-1;i>=0 && j>=0;i--,j--){
        	if(s1[i]+s2[j]-2*'0'+increase>=10){
        		result.push((char)(s1[i]+s2[j]+increase-'0'-10));
        		increase = 1;
        	}else{
        		result.push((char)(s1[i]+s2[j]+increase-'0'));
        		increase = 0;
        	}
        }
        char[] tmp = null;
        int tmpIndex = 0;
        if(i<0){
        	tmp = s2;
        	tmpIndex = j;
        }else{
        	tmp = s1;
        	tmpIndex = i;
        }
        while(tmpIndex>=0){
        	if(tmp[tmpIndex]+increase-'0'>=10){
        		result.push((char)(tmp[tmpIndex]+increase-10));
        		increase = 1;
        	}else{
        		result.push((char)(tmp[tmpIndex]+increase));
        		increase = 0;
        	}
        	tmpIndex--;
        }
        if(increase!=0){
        	result.push('1');
        }
        String r = "";
        while(!result.isEmpty()){
        	r+=result.pop();
        }
        return r;
    }
	
	public static void main(String[] args){
		AddStrings as = new AddStrings();
		String s1 = "99999";
		String s2 = "1";
		System.out.println(as.addStrings(s1, s2));
	}
}
