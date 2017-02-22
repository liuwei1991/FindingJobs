package astart.leetcode1;

public class NumberComplement {
	public int findComplement(int num) {
        int r = 0;
        int cur = 1;
        while(num!=0){
        	r+=(1-num%2)*cur;
        	cur*=2;
        	num/=2;
        }
        return r;
    }
}
