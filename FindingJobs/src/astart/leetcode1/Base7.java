package astart.leetcode1;

public class Base7 {
	//输入为0的时候特别注意
	public String convertToBase7(int num) {
		boolean positive = true;
        if(num<0){
        	positive = false;
        	num=-num;
        }
        if(num==0){
        	return "0";
        }
        String r = "";
        while(num!=0){
//        	 注意r的位置，在加号之前还是之后
        	r=String.valueOf(num%7)+r;
        	num/=7;
        }
        if(!positive){
        	r="-"+r;
        }
        return r;
    }
	
	public static void main(String[] args){
		Base7 b= new Base7();
		System.out.println(b.convertToBase7(-7));
	}
	
}
