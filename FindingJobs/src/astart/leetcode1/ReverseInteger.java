package astart.leetcode1;

public class ReverseInteger {
    public int reverse(int x) {
    	int positive = 1;
        if(x<0){
        	x = -x;
        	positive = -1;
        }
        long r = 0;
        while(x!=0){
        	r *= 10;
        	r += x%10;
        	x = x/10;
        }
        r = r*positive;
        if (r>Integer.MAX_VALUE || r<Integer.MIN_VALUE){
        	return 0;
        }else{
        	return (int)r;
        }
    }
    
    public static void main(String[] args){
    	ReverseInteger ri = new ReverseInteger();
    	int x = 1534236469;
    	System.out.print(ri.reverse(x));
    }
}
