package leetCode;

public class PermutationSequence {
	int A[] = new int[11];
	int n;

	public String getPermutation(int n, int k) {
		A[0] = 1;
		this.n = n;
		String result = "";
		boolean passed[] = new boolean[11];

		for (int i = 1; i <= n; i++) {
			A[i] = A[i - 1] * i;
		}
		if(k<1 || k>A[n]){
			return result;
		}
		for (int i = n - 1; i > 0; i--) {
			if (k < A[i]) {
				result += "" + get(1,passed);
			} else {
				result += "" + get(1 + (int) ((k - 0.5) / A[i]),passed);
				k =k%A[i];
				if(k==0){
					k=A[i];
				}
			}
		}
		result += "" + get(1,passed);
		return result;
	}

	public int get(int m,boolean[] passed) {
		int num = 0;
		for (int i = 0; i < n; i++) {
			if (passed[i]) {
				continue;
			}
			num++;
			if (num == m) {
				passed[i] = true;
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(3, 1));
		System.out.println(p.getPermutation(3, 2));
		System.out.println(p.getPermutation(3, 3));
		System.out.println(p.getPermutation(3, 4));
		System.out.println(p.getPermutation(3, 5));
		System.out.println(p.getPermutation(3, 7));
	}
}
