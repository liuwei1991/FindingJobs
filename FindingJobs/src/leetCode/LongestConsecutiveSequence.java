package leetCode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		HashSet<Integer> hash = new HashSet<Integer>();
		if (num == null || num.length == 0) {
			return 0;
		}
		for (int i = 0; i < num.length; i++) {
			hash.add(num[i]);
		}
		int result = 0;
		for (int a : num) {
			if (!hash.contains(a)) {
				continue;
			}
			int r = 0;
			int tmp = a-1;
			while(hash.contains(tmp)){
				r++;
				hash.remove(tmp);
				tmp--;
			}
			while(hash.contains(a)){
				r++;
				hash.remove(a);
				a++;
			}
			if(r>result) result =r;
		}
		return result;
	}
	public static void main(String[] args){
		LongestConsecutiveSequence lc = new LongestConsecutiveSequence();
		int[] num = {};
		System.out.println(lc.longestConsecutive(num));
	}
}
