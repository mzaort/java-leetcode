package interview2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BadHorse {
	public static void main(String[] args) throws FileNotFoundException{
		String infile = "F:\\Documents\\A-small-practice-2.in";
		String outfile = "test.out";
		Scanner sin = new Scanner(new File(infile));
		PrintWriter pwr = new PrintWriter(new File(outfile));
		
		BadHorse st = new BadHorse();
		int t = Integer.parseInt(sin.nextLine());
		for(int k = 1; k <= t; k++){
			st.buildGraph(sin);
			
			boolean val = st.solve();
			pwr.printf("Case #%d: %s\n", k, val ? "Yes" : "No");
		}
		
		sin.close();
		pwr.close();
	}

	private boolean solve() {
		int[] color = new int[v.size()];
		for(int i = 0; i < v.size(); i++){
			if(color[i] == 0){
				color[i] = 1;
				if(!dfs(color, i)) return false;
			}
		}
		return true;
	}
	
	private boolean dfs(int[] color, int n) {
		for(Integer i : e.get(n)){
			if(color[i] == 0) {
				color[i] = - color[n];
				if(!dfs(color, i)) return false;
			}else if(color[i] == color[n]) return false;
		}
		return true;
	}

	Map<String, Integer> v;
	List<List<Integer>> e;

	private void buildGraph(Scanner sin) {
		v = new HashMap<String, Integer>();
		e = new ArrayList<List<Integer>>();
		int m = Integer.parseInt(sin.nextLine());
		for(int i = 0, cur = 0; i < m; i++){
			String[] str = sin.nextLine().trim().split("\\s");
			if(!v.containsKey(str[0])){
				v.put(str[0], cur++);
				e.add(new ArrayList<Integer>());
			}
			if(!v.containsKey(str[1])){
				v.put(str[1], cur++);
				e.add(new ArrayList<Integer>());
			}
			int v1 = v.get(str[0]), v2 = v.get(str[1]);
			e.get(v1).add(v2);
			e.get(v2).add(v1);
		}
	}
}
