package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	private List<String> result = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		if(n<=0){
			return result;
		}
		this.solve(n, 0, "");
		return result;
	}

	public void solve(int n, int leftNum, String tmp) {
		if(leftNum>n||tmp.length()>2*leftNum){
			return;
		}
		if(leftNum==n && tmp.length()==2*n){
			result.add(tmp);
			return;
		}
		this.solve(n, leftNum+1, tmp + "(");
		this.solve(n, leftNum, tmp + ")");
	}
	
	public static void main(String[] args){
		GenerateParentheses gp = new GenerateParentheses();
		int n = 2;
		List<String> result = gp.generateParenthesis(n);
		for(String str:result){
			System.out.println(str);
		}
	}
}
