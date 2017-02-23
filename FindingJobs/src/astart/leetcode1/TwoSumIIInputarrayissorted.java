package astart.leetcode1;

public class TwoSumIIInputarrayissorted {
	public int[] twoSum(int[] numbers, int target) {
        int s=0,e=numbers.length-1;
        int sum = numbers[s]+numbers[e];
        while(sum!=target && s<e){
        	if(sum<target){
        		s+=1;
        	}else{
        		e-=1;
        	}
        	sum = numbers[s]+numbers[e];
        }
        return new int[]{s,e};
    }
}
