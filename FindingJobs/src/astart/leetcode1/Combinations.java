package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> combine(int n, int k) {
        if(n<k||n<0||k<0){
        	return result;
        }
        this.solve(new ArrayList<Integer>(), n, k, 0);
        return result;
    }
	
	private void solve(List<Integer> tmp,int n,int k,int start){
		if(tmp.size()==k){
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=start;i<n;i++){
			tmp.add(i+1);
			this.solve(tmp, n, k, i+1);
			tmp.remove(tmp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Combinations c = new Combinations();
		for (List<Integer> a : c.combine(4, 2)) {
			for (int b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
}
