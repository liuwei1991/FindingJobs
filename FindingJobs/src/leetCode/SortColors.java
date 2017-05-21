package leetCode;

public class SortColors {
	public void sortColors(int[] A) {
		int ws = 0;
		int we = A.length - 1;
		int i;
		for (i = A.length - 1; i >= 0; i--) {
			if (A[i] != 2) {
				we = i;
				break;
			}
		}
		for (i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				ws = i;
				break;
			}
		}
		for (i = ws; i <= we; i++) {
			if (A[i] == 0) {
				A[i] = A[ws];
				A[ws] = 0;
				ws++;
				i--;
			} else if (A[i] == 2) {
				A[i] = A[we];
				A[we] = 2;
				we--;
				i--;
			}
			if(i<ws) i= ws;
		}
		i = i;
	}
	public static void main(String[] args){
		SortColors sc = new SortColors();
		int a[] = {1,2,1,0,0,0,2,1,1,0,1,0};
		int b[] = {1,1,1,1,1,1,1};
		int c[] = {0,0,0,0,0,0,0};
		int d[] = {2,2,2,2,2,2,};
		int e[] = {2,2,0,0,2,0,2,1,0};
//		sc.sortColors(a);
//		sc.sortColors(b);
//		sc.sortColors(c);
//		sc.sortColors(d);
		sc.sortColors(e);
//		sc.sortColors(b);
	}
}
