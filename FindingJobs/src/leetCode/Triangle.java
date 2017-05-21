package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		ArrayList<Integer> pre = (ArrayList<Integer>) triangle.get(0);
		for (int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> cur = (ArrayList<Integer>) triangle.get(i);
			cur.set(0, pre.get(0) + cur.get(0));
			for (int j = 1; j < cur.size() - 1; j++) {
				cur.set(j, cur.get(j) + Math.min(pre.get(j), pre.get(j - 1)));
			}
			cur.set(cur.size() - 1,	pre.get(pre.size() - 1) + cur.get(cur.size() - 1));
			pre = cur;
		}
		int result = Integer.MAX_VALUE;
		for(int a:triangle.get(triangle.size()-1)){
			result = Math.min(a, result);
		}
		return result;
	}
}
