package leetCode;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			gas[i] -= cost[i];
		}
		int start = 0;
		for(start = 0;start<gas.length;start++){
			int left = 0;
			int i = start;
			
			while(true){
				left+=gas[i];
				if(left<0){
					break;
				}
				if(i>=gas.length-1){
					i=0;
				}else{
					i++;
				}
				if(i==start){
					return start;
				}
			}
		}
		if(start == gas.length){
			return -1;
		}
		return start;
	}
}
