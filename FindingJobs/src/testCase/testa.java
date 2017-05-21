package testCase;

import java.util.Scanner;

public class testa {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			String sub = "";
			int length = 0;
			for(int i=0;i<s.length();i++){
				for(int j=i+1;j<s.length();j++){
					String s1 = s.substring(i,j);
					if(s.indexOf(s1, i+1)>=0){
						if((j-i)>length){
							length = j-i;
							sub = s1;
						}
					}
				}
			}
			System.out.println(sub);
		}
	}
}
