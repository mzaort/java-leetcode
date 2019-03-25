package interview2018;

import java.util.Map;
import java.util.TreeMap;

public class BinaryTreesWithFactors {
	public int numFactoredBinaryTrees(int[] A) {
		// unique & >1
		TreeMap<Integer, Integer> f = new TreeMap<>();
		for (int e : A)
			f.put(e, 1);
		for (Map.Entry<Integer, Integer> a : f.entrySet()) {
			for (Map.Entry<Integer, Integer> b : f.headMap(a.getKey(), true).entrySet()) {
				int c = a.getKey() * b.getKey();
				if (f.containsKey(c)) {
					f.put(c, f.get(c) + (a.getKey() == b.getKey() ? a.getValue() * b.getValue()
							: a.getValue() * b.getValue() * 2));
				}
			}
		}
		return f.values().stream().reduce(Integer::sum).orElse(0);
	}

	public static void main(String[] args) {
		BinaryTreesWithFactors btwf = new BinaryTreesWithFactors();
		System.out.println(btwf.numFactoredBinaryTrees(new int[] { 45, 42, 2, 18, 23, 1170, 12, 41, 40, 9, 47, 24, 33,
				28, 10, 32, 29, 17, 46, 11, 759, 37, 6, 26, 21, 49, 31, 14, 19, 8, 13, 7, 27, 22, 3, 36, 34, 38, 39, 30,
				43, 15, 4, 16, 35, 25, 20, 44, 5, 48 }));
	}
}
