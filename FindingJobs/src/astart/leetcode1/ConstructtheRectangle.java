package astart.leetcode1;

public class ConstructtheRectangle {
	public int[] constructRectangle(int area) {
        int l = (int)Math.sqrt(area);
        int w = l;
        while(l*w!=area){
        	if(l*w<area){
        		l+=1;
        	}else if(l*w>area){
        		w-=1;
        	}
        }
        return new int[]{l,w};
    }
}
