package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return result;
		}
		List<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		result.add(pre);
		for (int i = 2; i <= numRows; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			for (int j = 1; j < i-1; j++) {
				tmp.add(pre.get(j - 1) + pre.get(j));
			}
			tmp.add(1);
			result.add(tmp);
			pre = tmp;
		}
		return result;
	}
	public static void main(String[] args){
		PascalsTriangle pt = new PascalsTriangle();
		List<List<Integer>> r = pt.generate(5);
		for(List<Integer> l:r){
			for(int a:l){
				System.out.print(a);
			}
			System.out.println();
		}
	}
}
