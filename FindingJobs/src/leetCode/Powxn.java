package leetCode;

public class Powxn {
	public double pow(double x, int n) {
		if(n==0) return 1;
		if(x==0) return 0;
		double result=1.0;
		double base = x;
		boolean positive=true;
		if(n<0){
			positive = false;
			n=-n;
		}
		
		while(n!=0){
			if(n%2!=0){
				if(positive){
					result *=base;
				}else{
					result/=base;
				}
			}
			base*=base;
			n/=2;
		}
		return result;
    }
	public static void main(String[] args){
		Powxn p = new Powxn();
		double x=2;
		int n=-2;
		System.out.println(p.pow(x, n));
	}
}
