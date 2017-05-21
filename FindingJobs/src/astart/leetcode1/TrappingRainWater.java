package astart.leetcode1;

public class TrappingRainWater {
	public int trap(int[] height) {
		if(height==null||height.length<=2){
			return 0;
		}
		int hightIndex = 0;
		int result = 0;
		int cur = 0;
		int curHigh = height[0];
		for(int i=1;i<height.length;i++){
			if(height[i]<curHigh){
				cur+=curHigh-height[i];
			}else{
				result+=cur;
				cur=0;
				hightIndex = i;
				curHigh = height[i];
			}
		}
		curHigh = height[height.length-1];
		cur = 0;
		for(int i=height.length-1;i>=hightIndex;i--){
			if(height[i]<curHigh){
				cur+=curHigh-height[i];
			}else{
				result+=cur;
				cur=0;
				curHigh = height[i];
			}
		}
		result += cur;
		return result;
    }
	
	public static void main(String[] args){
		TrappingRainWater tr = new TrappingRainWater();
		int[] height = {4,2,3};
		System.out.println(tr.trap(height));
	}
}
