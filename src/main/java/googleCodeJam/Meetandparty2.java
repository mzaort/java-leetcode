package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Meetandparty2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sin = new Scanner(new File("B-large-practice (1).in"));
		PrintWriter pwr = new PrintWriter(new File("B-large-practice.out"));
		int cnt = sin.nextInt();
		for (int k = 1; k <= cnt; k++) {
			int line = sin.nextInt();
			List<Point> list = new ArrayList<Point>();
			for (int i = 0; i < line; i++) {
				int x1 = sin.nextInt();
				int y1 = sin.nextInt();
				int x2 = sin.nextInt();
				int y2 = sin.nextInt();
				for (int x = x1; x <= x2; x++) {
					for (int y = y1; y <= y2; y++) {
						list.add(new Point(x, y));
					}
				}
			}
			long[] res = minDistance(list.toArray(new Point[0]));
			pwr.println("Case #" + k + ": " + res[0] + " " + res[1] + " " + res[2]);
		}
		sin.close();
		pwr.close();
	}

	private static long[] minDistance(Point[] array) {
		Point[] xcor = array;
		Point[] ycor = array.clone();
		Arrays.sort(xcor, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x < o2.x) return -1;
				else if (o1.x > o2.x) return 1;
				else return 0;
			}
		});
		Arrays.sort(ycor, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.y < o2.y) return -1;
				else if (o1.y > o2.y) return 1;
				else return 0;
			}
		});
		int len = xcor.length;
		long[] sx = new long[len];
		sx[0] = xcor[0].x;
		for (int i = 1; i < len; i++)
			sx[i] = sx[i - 1] + xcor[i].x;
		long[] sy = new long[len];
		sy[0] = ycor[0].y;
		for (int i = 1; i < len; i++)
			sy[i] = sy[i - 1] + ycor[i].y;

		long[] res = { 0, 0, Long.MAX_VALUE };
		for (int i = 0; i < len; i++) {
			int j = binarySearch(ycor, xcor[i]);
			long val = sx[len - 1] - 2 * sx[i] + ((long) (2 * i - len + 2)) * xcor[i].x + sy[len - 1] - 2 * sy[j]
					+ ((long) (2 * j - len + 2)) * ycor[j].y;

			if (val < res[2]) {
				res[0] = xcor[i].x;
				res[1] = xcor[i].y;
				res[2] = val;
			}
		}
		return res;
	}

	private static int binarySearch(Point[] ycor, Point point) {
		int left = 0, right = ycor.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >>> 1);
			if (point.y > ycor[mid].y) left = mid + 1;
			else if (point.y < ycor[mid].y) right = mid - 1;
			else return mid;
		}
		return left;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}