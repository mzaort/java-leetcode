package interview2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		if (tickets == null || tickets.length == 0) return null;

		Map<String, List<String>> map = new HashMap<>();
		for (String[] e : tickets) {
			if (!map.containsKey(e[0])) map.put(e[0], new ArrayList<>());
			map.get(e[0]).add(e[1]);
		}
		if (!map.containsKey("JFK")) return null;
		map.forEach((k, v) -> v.sort(Comparator.reverseOrder()));

		List<String> list = new ArrayList<>();
		List<String> res = new ArrayList<>(Arrays.asList("JFK"));
		String station = null;
		while (!map.isEmpty()) {
			int i = res.size() - 1;
			for (; i >= 0 && !map.containsKey(res.get(i)); i--);
			station = i >= 0 ? res.get(i) : "JFK";
			list.clear();
			while (map.containsKey(station)) {
				List<String> tmp = map.get(station);
				if (tmp.size() == 1) map.remove(station);
				station = tmp.remove(tmp.size() - 1);
				list.add(station);
			}
			int index = res.lastIndexOf(list.get(list.size() - 1));
			if (index >= 0) res.addAll(index + 1, list);
			else res.addAll(list);
		}

		return res;
	}

	public List<String> findItinerary2(String[][] tickets) {
		Map<String, PriorityQueue<String>> graph = new IdentityHashMap<>();
		for (String[] e : tickets) {
			graph.computeIfAbsent(e[0], k -> new PriorityQueue<String>()).add(e[1]);
		}
		LinkedList<String> res = new LinkedList<>();
		if (!graph.containsKey("JFK")) return res;
		dfs(graph, "JFK", res);
		return res;
	}

	private void dfs(Map<String, PriorityQueue<String>> graph, String vertex, LinkedList<String> res) {
		PriorityQueue<String> edges = graph.get(vertex);
		while (edges != null && !edges.isEmpty()) {
			dfs(graph, edges.poll(), res);
		}
		res.addFirst(vertex);
	}

	public static void main(String[] args) {
		String[][] pair = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		ReconstructItinerary ri = new ReconstructItinerary();
		System.out.println(ri.findItinerary2(pair));
	}
}
