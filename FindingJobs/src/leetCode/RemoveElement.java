package leetCode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int ans = A.length;
		int fillIndex = 0;
		for(int i=0;i<A.length;i++){
			if(A[i]!=elem){
				A[fillIndex++]=A[i];
			}else{
				ans--;
			}
		}
		return ans;
    }
}
