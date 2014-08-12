package testCase;

public class SuffixArray {
	int wa[], wb[], wv[], ws[];

	int cmp(int[] r, int a, int b, int l) {
		if (r[a] == r[b] && r[a + l] == r[b + l]) {
			return 1;
		}
		return 0;
	}

	void da(int[] r, int[] sa, int n, int m) {
		wa = new int[n * 2];
		wb = new int[n * 2];
		wv = new int[n];
		ws = new int[128];

		int i, j, p;
		int[] x = wa;
		int[] y = wb;
		int[] t;

		for (i = 0; i < m; i++) {
			ws[i] = 0;
		}
		for (i = 0; i < n; i++) {
			ws[x[i] = r[i]]++;
		}
		for (i = 1; i < m; i++) {
			ws[i] += ws[i - 1];
		}
		for (i = n - 1; i >= 0; i--) {
			sa[--ws[x[i]]] = i;
		}
		for (j = 1, p = 1; p < n; j *= 2, m = p) {
			for (p = 0, i = n - j; i < n; i++) {
				y[p++] = i;
			}
			for (i = 0; i < n; i++) {
				if (sa[i] >= j)
					y[p++] = sa[i] - j;
			}
			i = i;
			for (i = 0; i < n; i++) {
				wv[i] = x[y[i]];
			}
			for (i = 0; i < m; i++) {
				ws[i] = 0;
			}
			for (i = 0; i < n; i++) {
				ws[wv[i]]++;
			}
			for (i = 1; i < m; i++) {
				ws[i] += ws[i - 1];
			}
			for (i = n - 1; i >= 0; i--) {
				sa[--ws[wv[i]]] = y[i];
			}
			i = i;
			for (t = x, x = y, y = t, p = 1, x[sa[0]] = 0, i = 1; i < n; i++) {
				x[sa[i]] = (cmp(y, sa[i - 1], sa[i], j) == 1) ? p - 1 : p++;
			}
			i = i;
		}
		return;
	}

	int rank[];
	static int height[];

	void calheight(int[] r, int[] sa, int n) {
		rank = new int[r.length + 1];
		height = new int[r.length + 1];
		int i, j, k = 0;
		for (i = 1; i < n; i++) {
			rank[sa[i]] = i;
		}
		for (i = 0; i < n; height[rank[i++]] = k) {
			if (k > 0) {
				k--;
			}
			for (j = sa[rank[i] - 1]; (i + k) < r.length && (j + k) < r.length; k++) {
				if (r[i + k] != r[j + k]) {
					break;
				}
			}
		}
		return;
	}

	public static void main(String[] args) {
		String a = "aabaaaab";
		String b = "abaa";
		String s = a + "$" + b;
		SuffixArray sf = new SuffixArray();
		int[] r = new int[s.length()+1];
		int[] sa = new int[s.length()+1];
		for (int i = 0; i < s.length(); i++) {
			r[i] = s.charAt(i);
		}
		r[s.length()] = 0;
		sf.da(r, sa, r.length, 128);
		sf.calheight(r, sa, r.length-1);
		int ans = 0;
		int j = a.length();
		for (int i = 2; i <= r.length; i++) {
			if (height[i] > ans) {
				if ((j < sa[i - 1] && j > sa[i])
						|| (j > sa[i - 1] && j < sa[i])) {
					ans = height[i];
				}
			}
		}
		System.out.println(ans);
	}
}
