package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationIIwap {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	private boolean flags[];

	public List<List<Integer>> permuteUnique(int[] num) {
		flags = new boolean[num.length];
		Arrays.sort(num);
		this.solve(num, new ArrayList<Integer>(), 0);
		return result;
	}

	public void solve(int[] num, List<Integer> sequence, int level) {
		if (level == num.length) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (int a : sequence) {
				tmp.add(a);
			}
			result.add(tmp);
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if(flags[i] || i!=0 && num[i]==num[i-1] && flags[i-1]){
				continue;
			}
			sequence.add(num[i]);
			flags[i] = true;
			this.solve(num, sequence, level+1);
			flags[i] = false;
			sequence.remove(level);
		}
	}
	
	public static void main(String[] args){
		PermutationIIwap p = new PermutationIIwap();
		int num[] = {1,2,2};
		p.permuteUnique(num);
	}
}
