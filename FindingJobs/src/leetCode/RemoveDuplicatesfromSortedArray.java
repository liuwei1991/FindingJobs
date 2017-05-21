package leetCode;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		if(A==null) return 0;
		if(A.length ==0) return 0;
		int a = A[0];
		int fillIndex=1;
		for(int i=1;i<A.length;i++){
			if(A[i]==a){
				continue;
			}else{
				a = A[i];
				A[fillIndex++] = a;
			}
		}
		return fillIndex;
    }
	public static void main(String[] args){
		int[] A ={1,2,3,4,4,6,6,6};
		RemoveDuplicatesfromSortedArray rd = new RemoveDuplicatesfromSortedArray();
		System.out.println(rd.removeDuplicates(A));
	}
}
