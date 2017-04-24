package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> combine(int n, int k) {
		if (n < k) {
			return result;
		}
		this.solve(new ArrayList<Integer>(), 0, n, k);
		return result;
	}

	public void solve(List<Integer> tmp, int start, int n, int k) {
		if (tmp.size() == k) {
			result.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = start; i < n; i++) {
			tmp.add(i+1);
			this.solve(tmp, i + 1, n, k);
			tmp.remove(tmp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Combinations c = new Combinations();
		for (List<Integer> a : c.combine(4, 3)) {
			for (int b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
}
