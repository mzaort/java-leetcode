package googleCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) return null;
        return cloneGraph(new HashMap<Integer, UndirectedGraphNode>(), node);
    }

	private UndirectedGraphNode cloneGraph(
			Map<Integer, UndirectedGraphNode> map, UndirectedGraphNode node) {
		if(map.get(node.label) == null){
			UndirectedGraphNode cpy = new UndirectedGraphNode(node.label);
			map.put(cpy.label, cpy);
			for(UndirectedGraphNode e : node.neighbors){
				cpy.neighbors.add(cloneGraph(map, e));
			}
		}
		return map.get(node.label);
	}
	
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
    	if(node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode tmp = new UndirectedGraphNode(node.label);
        map.put(tmp.label, tmp);
        queue.offer(node);
        while((tmp = queue.poll()) != null){
        	UndirectedGraphNode cpy = map.get(tmp.label);
        	for(UndirectedGraphNode e : tmp.neighbors){
        		if(!map.containsKey(e.label)){
        			UndirectedGraphNode unode = new UndirectedGraphNode(e.label);
        			map.put(unode.label, unode);
        			queue.offer(e);
        		}
        		cpy.neighbors.add(map.get(e.label));
        	}
        }        
        return map.get(node.label);
    }
}
