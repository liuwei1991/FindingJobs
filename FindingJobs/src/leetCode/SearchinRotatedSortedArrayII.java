package leetCode;

public class SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int start = 0;
		int end = A.length-1;
		while(end>=start){
			int mid = (start+end)/2;
			if(A[end] == target || A[start]==target || A[mid]==target){
				return true;
			}
			if(target>A[end] && target<A[start]){
				return false;
			}
			
			if(A[start] == A[mid] && A[mid] == A[end]){
				for(int i=start+1;i<end;i++){
					if(A[i]==target){
						return true;
					}
				}
				return false;
			}
			
			if(A[mid]>A[start]){
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
			}else if(A[mid]==A[start]){
				start = mid+1;
				end -=1;
				continue;
			}else if(A[mid]==A[end]){
				end = mid-1;
				start +=1;
				continue;
			}else{
				return false;
			}
		}
		return false;
    }
	
	public static void main(String[] args){
		SearchinRotatedSortedArrayII sr = new SearchinRotatedSortedArrayII();
		int A[] = {2,2,2,0,0,1};
		System.out.println(sr.search(A, 0));
	}
}
