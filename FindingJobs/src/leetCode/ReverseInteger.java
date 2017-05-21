package leetCode;

public class ReverseInteger {
	public int reverse(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(x==0) return 0;
		String result = "";
		if(x<0){
			result += "-";
			x = -x;
		}
		while(x%10 == 0){
			x/=10;
		}
		while(x>=10){
			result += x%10;
			x/=10;
		}
		result += x;
        return Integer.valueOf(result);
    }
	
	public static void main(String[] args){
		ReverseInteger ri = new ReverseInteger();
		int x = 102;
		System.out.println(ri.reverse(x));
	}
}
