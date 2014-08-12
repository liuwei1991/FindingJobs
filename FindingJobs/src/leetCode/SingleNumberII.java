package leetCode;

public class SingleNumberII {
	public int singleNumber(int[] A) {
		int a =0;
		int b = 0;
		int c = 0;
		for(int tmp:A){
			b = b|(a&tmp);
			a = a^tmp;
			c = ~(a&b);
			a = a&c;
			b = b&c;
		}
		return a;
	}
}
