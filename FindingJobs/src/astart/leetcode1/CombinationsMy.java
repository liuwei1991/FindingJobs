package astart.leetcode1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationsMy {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> combine(int[] nums, int k) {
		this.solve(new ArrayList<Integer>(), 0, k, nums);
		return result;
    }
	
	public void solve(List<Integer> tmp,int start,int k,int[] nums){
		if(tmp.size()==k){
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=start;i<nums.length;i++){
			tmp.add(nums[i]);
			this.solve(tmp, i+1, k, nums);
			tmp.remove(tmp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(4);

		Set<Integer> set = new HashSet<Integer>(list);
		list = new ArrayList<Integer>(set);
		for(int a:list){
			System.out.println(a);
		}
	}
}
