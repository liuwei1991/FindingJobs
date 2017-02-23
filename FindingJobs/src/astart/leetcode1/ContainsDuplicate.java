package astart.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int c : nums) {
			if (map.containsKey(c)) {
				return true;
			} else {
				map.put(c, 1);
			}
		}
		return false;
	}
}
