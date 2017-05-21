package leetCode;

import java.util.Stack;

public class LargestRectangleinHistogram {
	
	// Time Limit Exceeded
	public int largestRectangleArea(int[] height) {
		if(height==null || height.length==0){
        	return 0;
        }
		int area = 0;
		for(int i=0;i<height.length;i++){
			area = Math.max(area, height[i]*(this.findEnd(height, i)-this.findStart(height, i)+1));
		}
		return area;
    }
	
	private int findStart(int[] height,int i){
		for(int j=i;j>=0;j--){
			if(height[j]<height[i]){
				return j+1;
			}
		}
		return 0;
	}
	
	private int findEnd(int[] height,int i){
		for(int j=i+1;j<height.length;j++){
			if(height[j]<height[i]){
				return j-1;
			}
		}
		return height.length-1;
	}
	
	
	public int largestRectangleArea1(int[] height) {
        if(height==null || height.length==0){
        	return 0;
        }
        int area = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<height.length;i++){
        	if(s.isEmpty()||height[s.peek()]<height[i]){
        		s.add(i);
        	}else{
        		int start = s.pop();
        		int length = s.isEmpty()?i:i-s.peek()-1;
        		area = Math.max(area, length*height[start]);
        		i--;
        	}
        }
        
        while(!s.isEmpty()){
        	int start = s.pop();
        	int length = s.isEmpty()?height.length:(height.length-s.peek()-1);
        	area = Math.max(area, length*height[start]);
        }
        return area;
    }
	
	public static void main(String[] args){
		LargestRectangleinHistogram lr = new LargestRectangleinHistogram();
		int[] height = {7,8,6,1,4};
		System.out.println(lr.largestRectangleArea(height));
	}
}
