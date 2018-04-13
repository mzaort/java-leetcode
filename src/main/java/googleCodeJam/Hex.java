package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hex {
	static String[] ans = {"Impossible", "Red wins", "Blue wins", "Nobody wins"};
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sin = new Scanner(new File("C-large-practice.in"));
		PrintWriter pwr = new PrintWriter(new File("C-large-practice.out"));
		int cnt = sin.nextInt();
		for(int k = 1; k <= cnt; k++){
			int n = sin.nextInt();
			sin.nextLine();
			char[][] maze = new char[n][n];
			for(int i = 0; i < n; i++){
				maze[i] = sin.nextLine().toCharArray();
			}
			int val = solve(maze);
			pwr.println("Case #" + k + ": " + ans[val]);
		}
		sin.close();
		pwr.close();
	}
	
	private static int solve(char[][] maze) {
		int len = maze.length;
		int red = 0, blue = 0;
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				if(maze[i][j] == 'R') red++;
				else if(maze[i][j] == 'B') blue++;
			}
		}
		int diff = red - blue;
		if(diff < -1 || diff > 1) return 0;
		List<Location> bpath = new ArrayList<Location>();
		List<Location> rpath = new ArrayList<Location>();
		boolean bflag = dfs(maze, new boolean[len][len], bpath, true);
		boolean rflag = dfs(maze, new boolean[len][len], rpath, false);
		if(bflag && rflag) return 0;
		if(!bflag && !rflag) return 3;
		if(bflag){
			if(diff == 1) return 0;
			for(Location e : bpath){
				boolean[][] flag2 = new boolean[len][len];
				flag2[e.x][e.y] = true;
				if(!dfs(maze, flag2, new ArrayList<Location>(), true)){
					return 2;
				}
			}
			return 0;
		}else{
			if(diff == -1) return 0;
			for(Location e : rpath){
				boolean[][] flag2 = new boolean[len][len];
				flag2[e.x][e.y] = true;
				if(!dfs(maze, flag2, new ArrayList<Location>(), false)){
					return 1;
				}
			}
			return 0;
		}
	}

	private static boolean dfs(char[][] maze, boolean[][] flag,
			List<Location> rpath, boolean b) {
		for (int i = 0; i < maze.length; i++) {
			if ((b && !flag[i][0] && maze[i][0] == 'B') || (!b && !flag[0][i] && maze[0][i] == 'R')) {
				rpath.clear();
				if (dfs(maze, b ? new Location(i, 0) : new Location(0, i),
						flag, rpath, b))
					return true;
			}
		}
		return false;
	}

	static int[][] dir = {{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}};
	private static boolean dfs(char[][] maze, Location loc,
			boolean[][] flag, List<Location> rpath, boolean b) {
		if((b && loc.y == maze.length - 1) || (!b && loc.x == maze.length - 1)){
			rpath.add(loc);
			return true;
		}
		flag[loc.x][loc.y] = true;
		rpath.add(loc);
		char ch = b ? 'B' : 'R';
		for(int i = 0; i < dir.length; i++){
			Location tmp = new Location(loc.x + dir[i][0], loc.y + dir[i][1]);
			if(isValid(tmp, maze.length) && maze[tmp.x][tmp.y] == ch && !flag[tmp.x][tmp.y]){
				if(dfs(maze, tmp, flag, rpath, b)) return true;
			}
		}
		rpath.remove(rpath.size() - 1);
		return false;
	}

	private static boolean isValid(Location loc, int len) {
		return loc.x >= 0 && loc.y >= 0 && loc.x < len && loc.y < len;
	}
}

class Location{
	int x;
	int y;
	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
