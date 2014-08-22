package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num==null||num.length<3){
        	return result;
        }
		Arrays.sort(num);
		for(int i=0;i<num.length;i++){
			if(i==0 ||num[i]>num[i-1]){
				int target = -num[i];
				int start = i+1;
				int end = num.length-1;
				while(end>start){
					if((num[start]+num[end])==target){
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[start]);
						tmp.add(num[end]);
						result.add(tmp);
						start++;
						end--;
						while(start<end && num[start]==num[start-1]){
							start++;
						}
						while(start<end && num[end]==num[end+1]){
							end--;
						}
					}else if((num[start]+num[end])<target){
						start++;
					}else{
						end--;
					}
				}
			}
        }
		return result;
    }
	public static void main(String[] args){
		int[] num= {-1,0,1,2,-1,-4};
		ThreeSum ts=new ThreeSum();
		ts.threeSum(num);
	}
}
