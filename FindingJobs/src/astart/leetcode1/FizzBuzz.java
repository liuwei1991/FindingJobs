package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> r = new ArrayList<String>();
        for(int i=1;i<=n;i++){
        	if(i%3==0 && i%5==0){
        		r.add("FizzBuzz");
        	}else if(i%3==0){
        		r.add("Fizz");
        	}else if(i%5==0){
        		r.add("Buzz");
        	}else{
        		r.add(String.valueOf(i));
        	}
        }
        return r;
    }
}
