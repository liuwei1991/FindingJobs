package astart.leetcode1;

public class PowerofThree {
	public boolean isPowerOfThree(int n) {
		if(n<=0){
			return false;
		}
        while(n>=3){
        	if(n%3!=0){
        		return false;
        	}
        	n = n/3;
        }
        if(n!=1){
        	return false;
        }
        return true;
    }
}
