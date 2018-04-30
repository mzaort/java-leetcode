package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class DragonMaze {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sin = new Scanner(new File("D-small-practice.in"));
		PrintWriter pwr = new PrintWriter(new File("D-small-practice.out"));
		int cnt = sin.nextInt();
		for (int k = 1; k <= cnt; k++) {
			int row = sin.nextInt();
			int col = sin.nextInt();
			int[][] maze = new int[row][col];
			Position frm = new Position(sin.nextInt(), sin.nextInt(), 0);
			Position end = new Position(sin.nextInt(), sin.nextInt(), 0);
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

	private static int maxPower(int[][] maze, Position frm, Position end) {
		int row = maze.length, col = maze[0].length;
		LinkedList<Position> queue = new LinkedList<Position>();
		frm.val = maze[frm.x][frm.y];
		queue.add(frm);
		Position front = null;
		while ((front = queue.poll()) != null) {
			if (front.equals(end)) {
				int max = front.val;
				while ((front = queue.poll()) != null) {
					if (front.val > max) max = front.val;
				}
				return max;
			}
			if (front.x + 1 < row && maze[front.x + 1][front.y] >= 0) {
				queue.add(new Position(front.x + 1, front.y, front.val + maze[front.x + 1][front.y]));
				maze[front.x + 1][front.y] = -2;
			}
			if (front.x - 1 >= 0 && maze[front.x - 1][front.y] >= 0) {
				queue.add(new Position(front.x - 1, front.y, front.val + maze[front.x - 1][front.y]));
				maze[front.x - 1][front.y] = -2;
			}
			if (front.y + 1 < col && maze[front.x][front.y + 1] >= 0) {
				queue.add(new Position(front.x, front.y + 1, front.val + maze[front.x][front.y + 1]));
				maze[front.x][front.y + 1] = -2;
			}
			if (front.y - 1 >= 0 && maze[front.x][front.y - 1] >= 0) {
				queue.add(new Position(front.x, front.y - 1, front.val + maze[front.x][front.y - 1]));
				maze[front.x][front.y - 1] = -2;
			}
		}
		return -1;
	}
}

class Position {
	int x;
	int y;
	int val;

	public Position(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return other.x == x && other.y == y;
	}

}
