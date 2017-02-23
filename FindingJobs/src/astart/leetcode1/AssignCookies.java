package astart.leetcode1;

import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
        int r = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for(int i=0;i<s.length&&j<g.length;i++){
        	if(s[i]>=g[j]){
        		j+=1;
        		r+=1;
        	}
        }
        return r;
    }
}
