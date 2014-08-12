package leetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<String>();
        
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].endsWith("+")){
        		Integer b = Integer.valueOf(s.pop());
        		Integer a = Integer.valueOf(s.pop());
        		s.push(String.valueOf(a+b));
        	}else if(tokens[i].endsWith("-")){
        		Integer b = Integer.valueOf(s.pop());
        		Integer a = Integer.valueOf(s.pop());
        		s.push(String.valueOf(a-b));
        	}else if(tokens[i].endsWith("*")){
        		Integer b = Integer.valueOf(s.pop());
        		Integer a = Integer.valueOf(s.pop());
        		s.push(String.valueOf(a*b));
        	}else if(tokens[i].endsWith("/")){
        		Integer b = Integer.valueOf(s.pop());
        		Integer a = Integer.valueOf(s.pop());
        		s.push(String.valueOf(a/b));
        	}else{
        		s.push(tokens[i]);
        	}
        }
    	return Integer.valueOf(s.pop());
    }
	
	public static void main(String args[]){
		EvaluateReversePolishNotation s = new EvaluateReversePolishNotation();
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(s.evalRPN(tokens));
		String[] tokenss = {"4", "13", "5", "/", "+"};
		System.out.println(s.evalRPN(tokenss));
	}
}
