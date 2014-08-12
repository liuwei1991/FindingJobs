package leetCode;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if(A==null||A.length==0){
			return 0;
		}
		int index = 1;
		int current = 0;
		int last = A[0];
		boolean twich = false;
		for(int i=1;i<A.length;i++){
			current = A[i];
			if(current == last && twich){
				continue;
			}else if(current == last && !twich){
				A[index++] = current;
				twich = true;
			}else if(current!=last){
				twich = false;
				last = current;
				A[index++] = current;
			}
		}
		return index;
    }
	public static void main(String[] args){
		RemoveDuplicatesfromSortedArrayII rd = new RemoveDuplicatesfromSortedArrayII();
		int[] a = {1,1,1,2,2,3,3,3,3,3,4};
		rd.removeDuplicates(a);
	}
}
