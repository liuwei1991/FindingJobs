package leetCode;

import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        for(int i=1;i<=numRows;i++){
        	ArrayList<Integer> t = new ArrayList<Integer>();
        	if(i==1){
        		t.add(1);
        	}else{
        		ArrayList<Integer> o = a.get(a.size()-1);
        		for(int j=0;j<o.size();j++){
        			if(j==0){
        				t.add(1);
        			}else{
        				t.add(o.get(j-1)+o.get(j));
        			}
        		}
        		t.add(1);
        	}
        	a.add(t);
        }
        return a;
    }
	
	public static void main(String args[]){
		PascalTriangle a = new PascalTriangle();
		ArrayList<ArrayList<Integer>> r = a.generate(5);
		for(int i=0;i<r.size();i++){
			for(int j=0;j<r.get(i).size();j++){
				System.out.print(r.get(i).get(j)+"  ");
			}
			System.out.println();
		}
			
	}
	
}
