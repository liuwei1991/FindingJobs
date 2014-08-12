package leetCode;

public class TrappingRainWater {
	public int trap(int[] A) {
		if(A==null || A.length==0){
			return 0;
		}
		int result = 0;
		boolean right = true;
		int start = 0;
		int end = A.length-1;
		int current = 0;
		while(end>start){
			int i=0;
			int tmp = 0;
			if(right){
				for(current=start+1;current<=end;current++){
					if(A[current]>=A[start]){
						result += tmp;
						start = current;
						break;
					}else{
						tmp+=A[start]-A[current];
					}
				}
				if(current==end+1){
					right = false;
				}
			}else{
				for(current=end-1;current>=start;current--){
					if(A[current]>=A[end]){
						result += tmp;
						end = current;
						break;
					}else{
						tmp+=A[end]-A[current];
					}
				}
				if(current == start-1){
					right = true;
				}
			}
		}
		return result;
    }
	public static void main(String[] args){
		TrappingRainWater tr = new TrappingRainWater();
//		int A[] ={0,1,0,2,1,0,1,3,1,2,1};
		int A[] = {2,0,2};
		System.out.println(tr.trap(A));
	}
}
