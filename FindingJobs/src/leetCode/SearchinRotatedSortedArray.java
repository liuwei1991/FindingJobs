package leetCode;

public class SearchinRotatedSortedArray {
	
	public int search(int[] A, int target) {
		int start = 0;
		int end = A.length-1;
		while(end>=start){
			if(A[end] == target){
				return end;
			}
			if(A[start]==target){
				return start;
			}
			if(target>A[end] && target<A[start]){
				return -1;
			}
			int mid = (start+end)/2;
			if(A[mid]==target){
				return mid;
			}else if(A[mid]>A[start]){
				if(target<A[mid] && target>A[start]){
					start+=1;
					end = mid-1;
					continue;
				}else{
					start = mid+1;
					end -=1;
					continue;
				}
			}else if(A[mid]<A[end]){
				if(target>A[mid] && target<A[end]){
					start = mid+1;
					end-=1;
					continue;
				}else{
					end = mid-1;
					start+=1;
					continue;
				}
			}else{
				return -1;
			}
		}
		return -1;
    }
	
	
	public static void main(String[] args){
		SearchinRotatedSortedArray sr = new SearchinRotatedSortedArray();
		int A[] = {1};
		System.out.println(sr.search(A, 0));
	}
}
