package leetcode2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		int count = 1;
		if(start.equals(end)){
			return 2;
		}
		if(dict.isEmpty()){
			return 0;
		}
		Queue<String> q = new LinkedList<String>();
		q.add(start);
		q.add("");
		while(!q.isEmpty()){
			String s = q.poll();
			if(!s.equals("")){
				for(int i=0;i<s.length();i++){
					for(char c='a';c<='z';c++){
						String tmp = s.substring(0, i)+c+s.substring(i+1);
						if(dict.contains(tmp)){
							if(tmp.equals(end)){
								return count+1;
							}
							q.add(tmp);
							dict.remove(tmp);
						}
					}
				}
			}else if(!q.isEmpty()){
				count ++;
				q.add("");
			}
		}
		return 0;
    }
}
