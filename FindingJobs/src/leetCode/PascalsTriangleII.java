package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		if(rowIndex == 0){
			result.add(1);
			return result;
		}
		for(int i=0;i<=rowIndex;i++){
			result.add(c(rowIndex,i));
		}
		return result;
    }
	
	public int c(int m,int n){
		if(m-n<n){
			n = m-n;
		}
		if(n==0||n==m){
			return 1;
		}
		int result =1;
		for(int i=1;i<=n;i++){
			int g = gcd(i,m+1-i);
			int b = (m+1-i)/g;
			int a = i/g;
			result/=a;
			result*=b;
		}
		return result;
	}
	
	public int gcd(int a,int b){
		if(a==0){
			return b;
		}else{
			return gcd(b%a,a);
		}
	}
	
	public static void main(String args[]){
		PascalsTriangleII pt = new PascalsTriangleII();
		pt.getRow(0);
	}
}
