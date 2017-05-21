package leetCode;

public class Sqrtx {
	public int sqrt(int x) {
		if(x<=1){
			return x;
		}
		long start = 1;
		long end = x;
		while(start<end){
			long mid = (start+end)/2;
			if((mid*mid)>x){
				end = mid-1;
			}else if((mid*mid)<x){
				start = mid+1;
			}else{
				return (int)mid;
			}
		}
		if(start*start>x){
			return (int)start-1;
		}else{
			return (int)start;
		}
    }
	public static void main(String[] args){
		Sqrtx s = new Sqrtx();
		int x = 4;
		System.out.println(s.sqrt(x));
	}
}
