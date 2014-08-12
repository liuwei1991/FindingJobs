package leetCode;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int start = 0;
		int end = A.length-1;
		while (end >= start) {
			int mid = (start + end) / 2;
			if (target == A[mid]) {
				int s = mid;
				while ( s >= 0) {
					if(A[s] == target){
						s--;
					}else{
						break;
					}
				
				}
				s++;
				int e = mid;
				while ( e < A.length) {
					if(A[e] == target ){
						e++;
					}else{
						break;
					}
				}
				e--;
				return new int[] { s, e };
			}
			if (target < A[mid]) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args){
		SearchForARange s = new SearchForARange();
		int A[] = new int[]{1, 4, 4, 8, 9, 9};
		int[] r = s.searchRange(A, 8);
		for(int i=0;i<r.length;i++){
			System.out.println(r[i]);
		}
	}
}
