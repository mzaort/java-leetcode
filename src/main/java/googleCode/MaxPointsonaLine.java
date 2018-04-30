package googleCode;

import java.util.Collections;
import java.util.HashMap;

public class MaxPointsonaLine {

	public static void main(String[] args) {
		MaxPointsonaLine mpl = new MaxPointsonaLine();
		Point[] points = { new Point(2, 3), new Point(3, 3), new Point(-5, 3) };
		System.out.println(mpl.maxPoints3(points));
	}

	public int maxPoints(Point[] points) {
		if (points.length <= 2) return points.length;

		int res = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			for (int j = i + 1; j < points.length; j++) {
				Double k = points[i].x == points[j].x ? Double.NaN
						: (points[i].y - points[j].y) / (points[i].x - points[j].x);
				if (map.get(k) == null) {
					map.put(k, 2);
				} else {
					map.put(k, map.get(k) + 1);
				}
			}
			for (Integer e : map.values()) {
				if (res < e) {
					res = e;
				}
			}
		}
		return res;
	}

	public int maxPoints2(Point[] points) {
		if (points.length <= 2) return points.length;

		int res = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			int same = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					same++;
				} else {
					// Double��0.0��-0.0�ǲ�ͬ��
					double k = points[i].x == points[j].x ? Double.NaN
							: ((double) points[i].y - points[j].y) / (points[i].x - points[j].x);
					if (k == -0.0) k = 0.0;
					if (map.get(k) == null) {
						map.put(k, 1);
					} else {
						map.put(k, map.get(k) + 1);
					}
				}
			}
			int max = 0;
			for (Integer e : map.values()) {
				if (max < e) max = e;
			}
			if (res < max + same + 1) res = max + same + 1;
		}
		return res;
	}

	public int maxPoints3(Point[] points) {
		int res = 0;
		Integer v = null;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			int same = 0, xsame = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					same++;
				} else if (points[i].x == points[j].x) {
					xsame++;
				} else {
					// Double��0.0��-0.0�ǲ�ͬ��
					double k = ((double) points[i].y - points[j].y) / (points[i].x - points[j].x);
					if (k == -0.0) k = 0.0;
					map.put(k, (v = map.get(k)) == null ? 1 : v + 1);
				}
			}
			int max = Math.max(xsame, map.size() == 0 ? 0 : Collections.max(map.values())) + same + 1;
			if (res < max) res = max;
		}
		return res;
	}
}
