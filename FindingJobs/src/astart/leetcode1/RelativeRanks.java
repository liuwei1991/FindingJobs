package astart.leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
        int[] tmp = new int[nums.length];
        String[] r = new String[nums.length];
        for(int i=0;i<nums.length;i++){
        	tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        Map<Integer,Integer> rank = new HashMap<Integer,Integer>();
        for(int i=0;i<tmp.length;i++){
        	rank.put(tmp[i], tmp.length - i);
        }
        for(int i=0;i<nums.length;i++){
        	int k = rank.get(nums[i]);
        	if(k==1){
        		r[i] = "Gold Medal";
        	}else if(k==2){
        		r[i] = "Silver Medal";
        	}else if(k==3){
        		r[i] = "Bronze Medal";
        	}else{
        		r[i] = String.valueOf(k);
        	}
        }
        return r;
    }

}
