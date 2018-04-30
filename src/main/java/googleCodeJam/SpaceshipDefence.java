package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpaceshipDefence {
	public static void main(String[] args) throws FileNotFoundException {
		String[] infile = { "test.in", "E-small-practice.in", "E-large-practice.in" };
		String[] outfile = { "test.out", "E-small-practice.out", "E-large-practice.out" };
		Scanner sin = new Scanner(new File(infile[2]));
		PrintWriter pwr = new PrintWriter(new File(outfile[2]));
		SpaceshipDefence st = new SpaceshipDefence();

		int cnt = Integer.parseInt(sin.nextLine());
		for (int k = 1; k <= cnt; k++) {
			int n = Integer.parseInt(sin.nextLine());
			Map<String, Integer> map = new HashMap<String, Integer>();
			int[] color = new int[n + 1];
			for (int i = 1, cur = 0; i <= n; i++) {
				String clr = sin.nextLine();
				if (!map.containsKey(clr)) {
					map.put(clr, cur++);
				}
				color[i] = map.get(clr);
			}
			int maxVertex = map.size();
			Integer[][] distance = new Integer[maxVertex][maxVertex];
			for (int i = 0; i < maxVertex; i++)
				distance[i][i] = 0;
			int t = sin.nextInt();
			for (int i = 0; i < t; i++) {
				int ai = color[sin.nextInt()];
				int bi = color[sin.nextInt()];
				int val = sin.nextInt();
				if (distance[ai][bi] == null || distance[ai][bi] > val) distance[ai][bi] = val;
			}
			int m = sin.nextInt();
			int[][] way = new int[m][2];
			for (int i = 0; i < m; i++) {
				way[i][0] = color[sin.nextInt()];
				way[i][1] = color[sin.nextInt()];
			}
			int[] res = st.findShortestPath(distance, way);
			pwr.println("Case #" + k + ":");
			for (int e : res)
				pwr.println(e);
			sin.nextLine();
		}

		sin.close();
		pwr.close();
	}

	private int[] findShortestPath(Integer[][] distance, int[][] way) {
		int len = distance.length;
		for (int k = 0; k < len; k++) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (distance[i][k] != null && distance[k][j] != null) {
						if (distance[i][j] == null || distance[i][j] > distance[i][k] + distance[k][j]) {
							distance[i][j] = distance[i][k] + distance[k][j];
						}
					}
				}
			}
		}
		int[] res = new int[way.length];
		for (int i = 0; i < way.length; i++) {
			res[i] = distance[way[i][0]][way[i][1]] == null ? -1 : distance[way[i][0]][way[i][1]];
		}
		return res;
	}
}
