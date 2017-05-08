package astart.leetcode1;

public class Powxn {
	public double myPow(double x, int n) {
		if(n==0){
			return 1;
		}
		if(n==1){
			return x;
		}
        if(n==-1){
        	return 1.0/x;
        }
        double tmp = this.myPow(x, n/2);
        return tmp*tmp*this.myPow(x, n%2);
    }
	
	public static void main(String[] args){
		int a = -7;
		System.out.println(a/2);
		System.out.println(a%2);
	}
}
