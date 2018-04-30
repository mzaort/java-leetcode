package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class DragonMaze2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sin = new Scanner(new File("D-large-practice.in"));
		PrintWriter pwr = new PrintWriter(new File("D-large-practice.out"));
		int cnt = sin.nextInt();
		for (int k = 1; k <= cnt; k++) {
			int row = sin.nextInt();
			int col = sin.nextInt();
			int[][] maze = new int[row][col];
			Pos frm = new Pos(sin.nextInt(), sin.nextInt());
			Pos end = new Pos(sin.nextInt(), sin.nextInt());
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					maze[i][j] = sin.nextInt();
				}
			}
			int val = maxPower(maze, frm, end);
			pwr.println("Case #" + k + ": " + (val == -1 ? "Mission Impossible." : val));
		}
		sin.close();
		pwr.close();
	}

	private static int maxPower(int[][] maze, Pos frm, Pos end) {
		LinkedList<Pos> queue = new LinkedList<Pos>();
		Map<Pos, int[]> map = new HashMap<Pos, int[]>();
		queue.add(frm);
		map.put(frm, new int[] { 0, maze[frm.x][frm.y] });
		Pos front = null;
		while ((front = queue.poll()) != null) {
			if (front.equals(end)) return map.get(front)[1];
			int[] tmp = map.get(front);
			next(maze, queue, map, front.right(), tmp);
			next(maze, queue, map, front.down(), tmp);
			next(maze, queue, map, front.left(), tmp);
			next(maze, queue, map, front.up(), tmp);
		}
		return -1;
	}

	private static void next(int[][] maze, LinkedList<Pos> queue, Map<Pos, int[]> map, Pos p, int[] tmp) {
		if (isValid(p, maze) && maze[p.x][p.y] != -1) {
			int[] val = map.get(p);
			if (val == null) {
				queue.add(p);
				map.put(p, new int[] { tmp[0] + 1, tmp[1] + maze[p.x][p.y] });
			} else {
				if (val[0] == tmp[0] + 1 && val[1] < tmp[1] + maze[p.x][p.y]) val[1] = tmp[1] + maze[p.x][p.y];
			}
		}
	}

	private static boolean isValid(Pos p, int[][] maze) {
		return p.x >= 0 && p.x < maze.length && p.y >= 0 && p.y < maze[0].length;
	}
}

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pos up() {
		return new Pos(x - 1, y);
	}

	public Pos left() {
		return new Pos(x, y - 1);
	}

	public Pos down() {
		return new Pos(x + 1, y);
	}

	public Pos right() {
		return new Pos(x, y + 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Pos other = (Pos) obj;
		if (x != other.x) return false;
		if (y != other.y) return false;
		return true;
	}
}
