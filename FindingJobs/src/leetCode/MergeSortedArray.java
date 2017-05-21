package leetCode;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int index = m + n - 1;
		int ia = m - 1;
		int ib = n - 1;
		while (ia >= 0 && ib >= 0) {
			if (A[ia] > B[ib]) {
				A[index--] = A[ia--];
				continue;
			} else {
				A[index--] = B[ib--];
				continue;
			}
		}
		while (ia >= 0) {
			A[index--] = A[ia--];
		}
		while (ib >= 0) {
			A[index--] = B[ib--];
		}
		return;
	}

	public static void main(String args[]) {
		MergeSortedArray ms = new MergeSortedArray();
		int a[] = {1,3,5,6,7,8,9,1,1,1,1,1,1,1,1,1,1,1};
		int b[] = {1,2,3,4,5};
		ms.merge(a, 3, b, 5);
	}
}
