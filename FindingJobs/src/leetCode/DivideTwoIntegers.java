package leetCode;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		boolean neg = false;
		if(dividend==0){
			return 0;
		}
		if((long)dividend * (long)divisor<0){
			neg = true;
		}
		long n = divisor;
		long m = dividend;
		n = Math.max(n, -n);
		m = Math.max(m, -m);
		int result = 0;
		while(m>=n){
			long tmp = n;
			int i=0;
			for(i=1;m>=tmp;i++){
				tmp = tmp<<1;
			}
			result+=1<<(i-2);
			m -= n * 1<<(i-2);
		}
		if(neg) return -result;
		return result;
    }
	public static void main(String[] args){
		DivideTwoIntegers dv = new DivideTwoIntegers();
		int n = 2147483647;
		int m = 2;
		System.out.println(dv.divide(n, m));
	}
}
