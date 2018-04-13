package googleapac;

import java.io.*;
import java.util.*;

public class SolutionD {
	public static void main(String[] args) throws FileNotFoundException{
		String[] infile = {"E:\\Document\\D-large-practice.in", "D-small.in", "D-large.in"};
		String[] outfile = {"test.out", "D-small.out", "D-large.out"};
		Scanner sin = new Scanner(new File(infile[0]));
		PrintWriter pwr = new PrintWriter(new File(outfile[0]));
		
		SolutionD st = new SolutionD();
		int t = Integer.parseInt(sin.nextLine());
		for(int k = 1; k <= t; k++){
			int n = sin.nextInt();
			int m = sin.nextInt();
			int[] A = new int[n];
			for(int i = 0; i < n; i++){
				A[i] = sin.nextInt();
			}
			pwr.println("Case #" + k + ": " + st.solve(A, m));
		}
		
		sin.close();
		pwr.close();
	}

	private int solve(int[] A, int m) {
		int cnt = 0;
		boolean[] flag = new boolean[A.length];
		Arrays.sort(A);
		for(int i = flag.length - 1; i >= 0 ; i--){
			if(!flag[i]){
				cnt++;
				PriorityQueue<Rect> queue = new PriorityQueue<Rect>();
				queue.offer(new Rect(m, m));
				dfs(A, flag, i, queue);
			}
		}
		return cnt;
	}

	private void dfs(int[] A, boolean[] flag, int cur, PriorityQueue<Rect> queue) {
		if(queue.size() == 0) return;
		Rect top = queue.peek();
		for(; cur >= 0 && top.height < (1 << A[cur]); cur--);
		for(; cur >= 0 && flag[cur]; cur--);
		if(cur == -1) return;
		
		flag[cur] = true;
		queue.poll();
		
		int square = 1 << A[cur];
		int downleft = top.height - square;
		int rightleft = top.width - square;
		if(downleft != 0) queue.offer(downleft < square ? new Rect(downleft, square) : new Rect(square, downleft));
		if(rightleft != 0) queue.offer(rightleft < square ? new Rect(rightleft, square) : new Rect(square, rightleft));
		if(downleft != 0 && rightleft != 0) queue.offer(new Rect(downleft, rightleft));
		dfs(A, flag, cur - 1, queue);
	}
	
	static class Rect implements Comparable<Rect>{
		int height;
		int width;
		public Rect(int hight, int width) {
			super();
			this.height = hight;
			this.width = width;
		}
		@Override
		public int compareTo(Rect o) {
			if(height < o.height) return 1;
			else if(height == o.height) return 0;
			else return -1;
		}
	}
}
