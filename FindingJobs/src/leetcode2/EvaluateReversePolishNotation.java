package leetcode2;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<String> q = new Stack<String>();
		if(tokens==null || tokens.length==0){
			return 0;
		}
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].equals("+")){
				int a = Integer.valueOf(q.pop());
				int b = Integer.valueOf(q.pop());
				int c = a+b;
				q.add(String.valueOf(c));
			}else if(tokens[i].equals("-")){
				int a = Integer.valueOf(q.pop());
				int b = Integer.valueOf(q.pop());
				int c = b-a;
				q.add(String.valueOf(c));
			}else if(tokens[i].equals("*")){
				int a = Integer.valueOf(q.pop());
				int b = Integer.valueOf(q.pop());
				int c = a*b;
				q.add(String.valueOf(c));
			}else if(tokens[i].equals("/")){
				int a = Integer.valueOf(q.pop());
				int b = Integer.valueOf(q.pop());
				int c = b/a;
				q.add(String.valueOf(c));
			}else{
				q.add(tokens[i]);
			}
		}
		return Integer.valueOf(q.pop());
    }
	public static void main(){
		EvaluateReversePolishNotation er = new EvaluateReversePolishNotation();
		
	}
}
