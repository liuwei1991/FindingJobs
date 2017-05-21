package leetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		this.generate(n, n,new String(), res);
		return res;
    }
	void generate(int left,int right,String s,List<String> res){
		if(left==0 && right ==0){
			res.add(s);
			return;
		}
		if(left>right){
			return;
		}
		if(left>0){
			this.generate(left-1, right, s+"(", res);
		}
		if(right>0){
			this.generate(left, right-1, s+")", res);
		}
	}
	
	public static void main(String[] args){
		GenerateParentheses gp = new GenerateParentheses();
		int n = 3;
		gp.generateParenthesis(n);
	}
}
