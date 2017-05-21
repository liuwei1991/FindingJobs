package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	private int k;
	private int n;

	public List<List<Integer>> combine(int n, int k) {
		this.n = n;
		this.k = k;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (k > n)
			return result;
		this.getReult(result, new ArrayList<Integer>(), 1, 0);
		return result;
	}

	public void getReult(List<List<Integer>> result, List<Integer> tmp,
			int start, int level) {
		if (level >= k) {
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = start; i <= n; i++) {
			tmp.add(i);
			this.getReult(result, tmp, i + 1, level + 1);
			tmp.remove(tmp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Combinations c = new Combinations();
		int n = 4;
		int k = 5;
		c.combine(n, k);
	}
}
