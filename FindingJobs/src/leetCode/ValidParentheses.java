package leetCode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		char[] seq = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<seq.length;i++){
			char top ;
			if(seq[i]==')' || seq[i]==']' ||seq[i]=='}'){
				if(stack.isEmpty()){
					return false;
				}else{
					top = stack.pop();
					if(top == '(' && seq[i]==')'){
						continue;
					}else if(top == '[' && seq[i]==']'){
						continue;
					}else if(top == '{' && seq[i]=='}'){
						continue;
					}else{
						return false;
					}
				}
			}else{
				stack.add(seq[i]);
			}
		}
		if(stack.isEmpty()){
			return true;
		}
		return false;
    }
	
	public static void main(String[] args){
		ValidParentheses vp = new ValidParentheses();
		String s = "([)]";
		System.out.println(vp.isValid(s));
	}
}
