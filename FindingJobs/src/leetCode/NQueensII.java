package leetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	private int ans = 0;

	public int totalNQueens(int n) {
		int flags[] = new int[n];
		this.NQueues(flags, 0, n);
		return ans;
	}

	public void NQueues( int[] flags, int start, int total) {
		if (start == total) {
			ans++;
			return;
		}
		for (int i = 0; i < total; i++) {
			if (fit(flags, start, i)) {
				flags[start] = i;
				NQueues(flags, start + 1, total);
			}
		}
	}

	public boolean fit(int[] flags, int indexStart, int m) {
		for (int i = 0; i < indexStart; i++) {
			if (m == flags[i]) {
				return false;
			} else {
				if (Math.abs(flags[i] - m) == indexStart - i) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(4));
	}

}
