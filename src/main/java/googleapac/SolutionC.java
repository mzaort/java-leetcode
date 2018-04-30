package googleapac;

import java.io.*;
import java.util.*;

public class SolutionC {
	public static void main(String[] args) throws FileNotFoundException {
		String infile = "E:\\Document\\C-large-practice.in";
		String outfile = "test.out";
		Scanner sin = new Scanner(new File(infile));
		PrintWriter pwr = new PrintWriter(new File(outfile));

		SolutionC st = new SolutionC();
		int t = Integer.parseInt(sin.nextLine());
		for (int k = 1; k <= t; k++) {
			int n = Integer.parseInt(sin.nextLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
			for (int i = 0, cur = 0; i < n; i++) {
				String equation = sin.nextLine();
				String[] opr = equation.split("=|\\+");
				if (!map.containsKey(opr[0])) {
					map.put(opr[0], cur++);
					graph.add(new ArrayList<Edge>());
				}
				if (!map.containsKey(opr[1])) {
					map.put(opr[1], cur++);
					graph.add(new ArrayList<Edge>());
				}
				int n1 = map.get(opr[0]), n2 = map.get(opr[1]), nval = Integer.parseInt(opr[2]);
				graph.get(n1).add(new Edge(n2, nval));
				graph.get(n2).add(new Edge(n1, nval));
			}
			pwr.println("Case #" + k + ":");
			int q = Integer.parseInt(sin.nextLine());

			for (int i = 0; i < q; i++) {
				String equation = sin.nextLine();
				String[] opr = equation.split("\\+");
				Integer n1 = map.get(opr[0]), n2 = map.get(opr[1]);
				if (n1 != null && n2 != null) {
					State[] states = new State[map.size()];
					states[n1] = new State(1, 0, true);
					if (st.dfs(graph, n1, n2, states)) {
						pwr.println(equation + "=" + states[n2].val);
					}
				}
			}
		}

		sin.close();
		pwr.close();
	}

	private boolean dfs(ArrayList<ArrayList<Edge>> graph, int n1, int n2, State[] states) {
		if (n1 == n2 && !states[n2].positive) return true;
		State sn1 = states[n1];
		for (Edge e : graph.get(n1)) {
			if (states[e.node] == null) {
				states[e.node] = new State(1, e.val - sn1.val, !sn1.positive);
				if (dfs(graph, e.node, n2, states)) return true;
			} else if (states[e.node].visited == 1 && states[e.node].positive == sn1.positive) {
				states[e.node] = new State(2, e.val - sn1.val, !sn1.positive);
				if (dfs(graph, e.node, n2, states)) return true;
			}
		}
		return false;
	}

	static class State {
		int visited;
		int val;
		boolean positive;

		public State(int visited, int val, boolean positive) {
			super();
			this.visited = visited;
			this.val = val;
			this.positive = positive;
		}
	}

	static class Edge {
		int node;
		int val;

		public Edge(int node, int val) {
			this.node = node;
			this.val = val;
		}
	}
}
