package leetCode;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int i=0;
		int j = height.length-1;
		while(i<j){
			int area = (j-i)*Math.min(height[i], height[j]);
			maxArea = Math.max(maxArea, area);
			if(height[i]>height[j]){
				j--;
			}else{
				i++;
			}
		}
		return maxArea;
    }
	
	public static void main(String[] args){
		ContainerWithMostWater cw = new ContainerWithMostWater();
		
	}
}
