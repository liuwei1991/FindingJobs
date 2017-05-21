package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null) return null;
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode,UndirectedGraphNode> m = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		m.put(node, head);
		List<UndirectedGraphNode> oldNei = node.neighbors;
		List<UndirectedGraphNode> newNei = new ArrayList<UndirectedGraphNode>();
		for(UndirectedGraphNode ug:oldNei){
			if(!m.containsKey(ug)){
				UndirectedGraphNode tmp = new UndirectedGraphNode(ug.label);
				newNei.add(tmp);
				m.put(ug, tmp);
				q.add(ug);
			}else{
				newNei.add(m.get(ug));
			}
		}
		m.get(node).neighbors = newNei;
		while(!q.isEmpty()){
			UndirectedGraphNode cur = q.poll();
			oldNei = cur.neighbors;
			newNei = new ArrayList<UndirectedGraphNode>();
			for(UndirectedGraphNode ug:oldNei){
				if(!m.containsKey(ug)){
					UndirectedGraphNode tmp = new UndirectedGraphNode(ug.label);
					newNei.add(tmp);
					m.put(ug, tmp);
					q.add(ug);
				}else{
					newNei.add(m.get(ug));
				}
			}
			m.get(cur).neighbors = newNei;
		}
		
		return head;
	}
	public static void main(String[] args){
		
	}
}
