package astart.leetcode1;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int r = 0;
		while(x!=0 || y!=0){
			int x1 = x%2;
			int y1 = y%2;
			r += x1==y1?0:1;
			x = x/2;
			y = y/2;
		}
		return r;
    }
}
