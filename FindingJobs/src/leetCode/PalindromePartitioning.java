package leetCode;

import java.util.ArrayList;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        String befor = "";
        
        this.solve(s, befor, result);
		return result;
    }
	
	public void solve(String s,String befor,ArrayList<ArrayList<String>> result){
		if(this.isPalindrome(s)){
			ArrayList<String> element = new ArrayList<String>();
			String kk = befor +","+s;
			String[] tmp = kk.split(",");
	        for(int i=1;i<tmp.length;i++){
	        	element.add(tmp[i]);
	        }
			result.add(element);
		}
		
		for(int i=1;i<s.length();i++){
			if(this.isPalindrome(s.substring(0, i))){
				solve(s.substring(i),befor+","+s.substring(0, i),result);
			}
		}
	}
	
	public boolean isPalindrome(String s){
		char se[] = s.toCharArray();
		for(int i=0;i<s.length();i++){
			if(se[i]!=se[se.length-1-i]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		PalindromePartitioning pp = new PalindromePartitioning();
		String s = "bb";
		for(ArrayList<String> ss:pp.partition(s)){
			for(String t:ss){
				System.out.print(t+",");
			}
			System.out.println();
		}
	}
}
