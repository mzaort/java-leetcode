package googleCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NonRecursiveDFS {
	public List<Integer> dfs(UndirectedGraphNode g){
		List<Integer> res = new ArrayList<Integer>();
		if(g != null){
			LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
			Set<UndirectedGraphNode> visit = new HashSet<UndirectedGraphNode>();
			stack.add(g);
			UndirectedGraphNode top = null;
			while((top = stack.poll()) != null){
				if(!visit.contains(top)){
					res.add(top.label);
					visit.add(top);
					for (UndirectedGraphNode e : top.neighbors) {
						if (!visit.contains(e)) {
							stack.push(e);
						}
					}
				}
			}
		}
		return res;
	}
}
