package leetCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<(1<<n);i++){
			result.add(i^(i>>1));
		}
		return result;
    }
	
	public static void main(String[] args){
		GrayCode gc = new GrayCode();
		gc.grayCode(2);
	}
}
