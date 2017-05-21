package leetCode;

public class ValidNumber {
	public boolean isNumber(String s) {
		int inputp[] ={
				0,//for invalid input
				1,//for +/-
				2,//for.
				3,//for digit
				4 //for e
		};
		int[][] transf={
				{-1,3,1,2,-1},
				{-1,-1,-1,4,-1},
				{-1,-1,4,2,5},
				{-1,-1,1,2,-1},
				{-1,-1,-1,4,5},
				{-1,6,-1,7,-1},
				{-1,-1,-1,7,-1},
				{-1,-1,-1,7,-1}
		};
		int status = 0;
		s = s.trim();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='+' ||c=='-'){
				status = transf[status][1];
			}else if(c=='.'){
				status = transf[status][2];
			}else if(c>='0' && c<='9'){
				status = transf[status][3];
			}else if(c=='e'){
				status = transf[status][4];
			}else{
				status = transf[status][0];
			}
			if(status==-1){
				return false;
			}
		}
		return status==2||status==4||status==7;
    }
	
	public static void main(String[] args){
		ValidNumber vn = new ValidNumber();
		String s = "23572e23";
		s="3.";
		System.out.println(vn.isNumber(s));
	}
}
