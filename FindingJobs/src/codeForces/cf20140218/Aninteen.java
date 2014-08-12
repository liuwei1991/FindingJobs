package codeForces.cf20140218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aninteen {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		str = br.readLine();

		int n=0,i=0,e=0,t=0;
		for(int num=0; num<str.length();num++){
			if(str.charAt(num)=='n'){
				n++;
			}else if(str.charAt(num)=='i'){
				i++;
			}else if(str.charAt(num)=='e'){
				e++;
			}else if(str.charAt(num)=='t'){
				t++;
			}
		}
		
		int result = i;
		if(t<result){
			result = t;
		}
		if(((n-1)/2)<result){
			result = (n-1)/2;
		}
		if((e/3)<result){
			result=e/3;
		}
		System.out.println(result);
	}
}
