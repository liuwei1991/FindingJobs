package leetCode;

public class JumpGame {
	public boolean canJump(int[] A) {
		int max =  A[0];
		if(max>A.length){
			return true;
		}
        for(int i=1;i<A.length;i++){
        	if(i>max){
        		return false;
        	}else{
        		if((i+A[i])>max){
        			max = A[i]+i;
        			if(max>A.length){
        				return true;
        			}
        		}
        	}
        }
        return true;
    }
	
	public static void main(String[] args){
		JumpGame jg = new JumpGame();
//		int[] a = {2,3,1,1,4};
		int[] a = {3,2,1,0,4};
//		int[] a = {1,2,3};
		System.out.println(jg.canJump(a));
	}
	
}
