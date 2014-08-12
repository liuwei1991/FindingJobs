package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<Integer> tmp = new ArrayList<Integer>();
	public boolean[] flags;

	public List<List<Integer>> permute(int[] num) {
		List<Integer> tmp = new ArrayList<Integer>();
		this.flags = new boolean[num.length];
		Arrays.sort(num);
		this.solve(num, tmp, 0);
		return result;
	}

	public void solve(int[] num, List<Integer> tmp, int start) {
		if (start == num.length) {
			List<Integer> val = new ArrayList<Integer>();
			for (int a : tmp) {
				val.add(a);
			}
			result.add(val);
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (flags[i] || i != 0 && num[i - 1] == num[i] && flags[i - 1]) {
				continue;
			}
			flags[i] = true;
			tmp.add(num[i]);
			this.solve(num, tmp, start + 1);
			flags[i] = false;
			tmp.remove(tmp.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 1 };
		Permutations p = new Permutations();
		p.permute(num);
	}
}
