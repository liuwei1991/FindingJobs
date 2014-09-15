package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		if(node ==null){
			return null;
		}
		Map<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
		return this.clone(node, map);
	}
	
	private UndirectedGraphNode clone(UndirectedGraphNode node
			,Map<Integer,UndirectedGraphNode> map){
		if(map.containsKey(node.label)){
			return map.get(node.label);
		}
		UndirectedGraphNode nNode = new UndirectedGraphNode(node.label);
		map.put(node.label,nNode);
		
		List<UndirectedGraphNode> neighbor = new ArrayList<UndirectedGraphNode>();
		for(UndirectedGraphNode nei: node.neighbors){
			neighbor.add(clone(nei,map));
		}
		nNode.neighbors = neighbor;
		return nNode;
	}
}
