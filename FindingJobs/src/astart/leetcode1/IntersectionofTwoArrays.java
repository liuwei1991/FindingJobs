package astart.leetcode1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0,j=0;i<nums1.length && j<nums2.length;){
        	if(nums1[i]==nums2[j]){
        		s.add(nums1[i]);
        		i+=1;
        		j+=1;
        	}else if(nums1[i]>nums2[j]){
        		j+=1;
        	}else if(nums1[i]<nums2[j]){
        		i+=1;
        	}
        }
        int[] intr = new int[s.size()];
        int i = 0;
        for(int item:s){
        	intr[i] = item;
        	i++;
        }
        return intr;
    }
	
	public static void main(String[] args){
		int[] nums1 = {1};
		int[] nums2 = {1};
		IntersectionofTwoArrays it = new IntersectionofTwoArrays();
		for(int item:it.intersection(nums1, nums2)){
			System.out.println(item);
		}
	}
}
