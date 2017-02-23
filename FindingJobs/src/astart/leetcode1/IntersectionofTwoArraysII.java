package astart.leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int c : nums1) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		List<Integer> rlist = new ArrayList<Integer>();
		for(int num:nums2){
			if (map.containsKey(num)&&map.get(num)>=1) {
				map.put(num, map.get(num)-1);
				rlist.add(num);
			}
		}
		int[] intr = new int[rlist.size()];
        int i = 0;
        for(int item:rlist){
        	intr[i] = item;
        	i++;
        }
		return intr;
    }
}
