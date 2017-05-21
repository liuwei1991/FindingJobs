package leetCode;

/**
 * 注意命名规则，注意为跳步零的情况
 * @author Ares
 *
 */
public class JumpGameII {

	public int jump(int[] A) {
		if(A==null || A.length==1){
			return 0;
		}
		int jump = 1;
		int preIndex = 0;
		int curIndex = 0;
		int current = 0;
		while(current<A.length){
			while(current<=preIndex){
				if((A[current]+current)>curIndex){
					curIndex = current+A[current];
					if(curIndex>=A.length-1){
						return jump;
					}
				}
				current++;
			}
			if(preIndex == curIndex){
				return -1;
			}
			preIndex = curIndex;
			jump++;
		}
		
		return jump;
    }
	
	public static void main(String[] args){
		int a[]={3,4,3,1,0,7,0,3,0,2,0,3};
		JumpGameII gm = new JumpGameII();
		System.out.println(gm.jump(a));
	}
}
