package astart.leetcode1;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index= m+n-1;
        while(m>0 ||n>0){
        	if(m<=0){
        		while(n>0){
        			nums1[index--] = nums1[n-1];
        			n--;
        		}
        		return;
        	}
        	if(n<=0){
        		while(m>0){
        			nums1[index--] = nums2[m-1];
        			m--;
        		}
        		return;
        	}
        	
        	if(nums1[m-1]>nums2[n-1]){
        		nums1[index--] = nums1[m-1];
        		m-=1;
        	}else if(nums1[m-1]<=nums2[n-1]){
        		nums1[index--] = nums2[m-1];
        		n-=1;
        	}
        }
    }
}
