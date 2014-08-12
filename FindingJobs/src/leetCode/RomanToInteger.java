package leetCode;

public class RomanToInteger {
	 public int romanToInt(String s) {
		 if(s==null){
			 return 0;
		 }
		 if(s.length()==0){
			 return 0;
		 }
		 int result = getValue(s.charAt(0));
		 for(int i=1;i<s.length();i++){
			 int pre = this.getValue(s.charAt(i-1));
			 int cur = this.getValue(s.charAt(i));
			 if(cur<=pre){
				 result += cur;
			 }else{
				 result = result+cur-2*pre;
			 }
		 }
		 return result;
	 }
	 
	 public int getValue(char a){
		 switch(a){
		 	case 'I':
		 		return 1;
		 	case 'V':
		 		return 5;
		 	case 'X':
		 		return 10;
		 	case 'L':
		 		return 50;
		 	case 'C':
		 		return 100;
		 	case 'D':
		 		return 500;
		 	case 'M':
		 		return 1000;
		 }
		 return -1;
	 }
	 public static void main(String args[]){
		 RomanToInteger r = new RomanToInteger();
		 System.out.print(r.romanToInt("MXDIII"));
	 }
}
