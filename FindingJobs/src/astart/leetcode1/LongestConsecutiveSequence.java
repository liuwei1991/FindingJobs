package astart.leetcode1;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (nums == null || nums.length == 0) {
			return 0;
		}
		for (int a : nums) {
			map.put(a, 1);
		}
		while (!map.isEmpty()) {
			int key = 0;
			for (int tmp : map.keySet()) {
				key = tmp;
				break;
			}
			int tmpResult = 1;
			map.remove(key);

			int tmp = key - 1;
			while (map.containsKey(tmp)) {
				map.remove(tmp);
				tmp--;
				tmpResult += 1;
			}
			tmp = key + 1;
			while (map.containsKey(tmp)) {
				map.remove(tmp);
				tmp++;
				tmpResult += 1;
			}
			result = Math.max(result, tmpResult);
		}
		return result;
	}
}
