package astart.leetcode1;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();

        int result = 0;
        int start = -1;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='('){
        		stack.push(i);
        	}else{
        		if(stack.isEmpty()){
        			start = i;
        		}else{
        			stack.pop();
        			if(stack.isEmpty()){
        				result = Math.max(result, i-start);
        			}else{
        				result = Math.max(result, i-stack.peek());
        			}
        		}
        	}
        }
        return result;
    }
	public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);            
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
	
	public static void main(String[] args){
		LongestValidParentheses lv = new LongestValidParentheses();
		String s = "()((()))))";
		System.out.print(lv.longestValidParentheses(s));
	}
}
