package leetCode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	private List<List<String>> result = new ArrayList<List<String>>();

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		if (start.equals(end)) {
			return result;
		}
		ArrayList<String> tmp = new ArrayList<String>();
		Queue<List<String>> q = new LinkedList<List<String>>();
		tmp.add(start);
		q.add(tmp);
		q.add(new ArrayList<String>());
		boolean found = false;
		while(!q.isEmpty()){
			List<String> l = q.poll();
			if(l.isEmpty()){
				if(q.size()==0){
					break;
				}
				if(found){
					break;
				}
				q.add(new ArrayList<String>());
			}else{
				dict.removeAll(l);
				String cur = l.get(l.size()-1);
				for(int i=0;i<cur.length();i++){
					for(char c='a';c<='z';c++){
						String ns = cur.substring(0,i)+c+cur.substring(i+1);
						if(ns.equals(end)){
							l.add(end);
							result.add(new ArrayList<String>(l));
							found = true;
							l.remove(end);
							dict.addAll(l);
							break;
						}else if(dict.contains(ns)){
							l.add(ns);
							q.add(new ArrayList<String>(l));
							l.remove(ns);
						}
					}
				}
				dict.addAll(l);
			}
		}
		return result;
	}

	public static void main(String args[]) {
		WordLadderII wl = new WordLadderII();
		Set<String> s = new LinkedHashSet<String>();
		s.add("hot");
		s.add("dot");
		s.add("dog");
		s.add("lot");
		s.add("log");
		String start = "hit";
		String end = "cog";
		wl.findLadders(start, end, s);
	}
}
