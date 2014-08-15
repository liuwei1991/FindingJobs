package leetCode;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		if(A==null||A.length==0){
			return 1;
		}
		for(int i=0;i<A.length;i++){
			while(A[i]>0 && A[i]!=i+1 && A[i]<A.length && A[i]!=A[A[i]-1]){
				int tmp = A[i];
				A[i] = A[tmp-1];
				A[tmp-1] = tmp;
			}
		}
		for(int i=0;i<A.length;i++){
			if(A[i]!=i+1){
				return i+1;
			}
		}
		return A.length+1;
    }
	
	public static void main(String[] args){
		FirstMissingPositive fm = new FirstMissingPositive();
		int A[] = {1,1};
		System.out.println(fm.firstMissingPositive(A));
	}
}
