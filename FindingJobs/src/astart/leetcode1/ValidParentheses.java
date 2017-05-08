package astart.leetcode1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        Stack<Character> q = new Stack<Character>();
        char[] cs = s.toCharArray();
        for(char c:cs){
        	if(c=='('||c=='{'||c=='['){
        		q.add(c);
        	}
        	if(c==')'){
        		if(q.isEmpty()){
        			return false;
        		}
        		char tmp = q.pop();
        		if(tmp!='('){
        			return false;
        		}
        	}else if(c=='}'){
        		if(q.isEmpty()){
        			return false;
        		}
        		char tmp = q.pop();
        		if(tmp!='{'){
        			return false;
        		}
        	}else if(c==']'){
        		if(q.isEmpty()){
        			return false;
        		}
        		char tmp = q.pop();
        		if(tmp!='['){
        			return false;
        		}
        	}
        }
        if(q.isEmpty()){
			return true;
		}
        return false;
    }
	
	public static void main(String[] args){
		ValidParentheses vp = new ValidParentheses();
		String input = "([)]";
		System.out.println(vp.isValid(input));
	}
}
