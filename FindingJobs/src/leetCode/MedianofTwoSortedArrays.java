package leetCode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		if(A.length==0 && B.length==0){
			return 0;
		}
        if((A.length+B.length)%2==0){
        	return (findK(A,B,(A.length+B.length)/2)
        			+findK(A,B,(A.length+B.length)/2+1) )/2.0;
        }else{
        	return findK(A,B,(A.length+B.length+1)/2);
        }
    }
	
	private int findK(int A[],int B[],int k){
		if(A.length==0){
			return B[k-1];
		}
		if(B.length==0){
			return A[k-1];
		}
		if(k==1){
			return Math.min(A[0], B[0]);
		}
		if(A.length>B.length){
			return findK(B,A,k);
		}
		int a = Math.min(A.length, k/2);
		int b = k-a;
		if(A[a-1]<B[b-1]){
			return findK(B,Arrays.copyOfRange(A, a, A.length),k-a);
		}else if(A[a-1]>B[b-1]){
			return findK(Arrays.copyOfRange(B, b, B.length),A,k-b);
		}else{
			return A[a-1];
		}
	}
	
	public static void main(String[] args){
		MedianofTwoSortedArrays mt = new MedianofTwoSortedArrays();
		int A[] = {1};
		int B[] = {1};
		System.out.println(mt.findMedianSortedArrays(A, B));
	}
}
