package blind;

import java.util.Arrays;

public class ArrayProblem {
	public static void main(String[] args) {
		// char[][] cs = new char[2][];
		// cs[0] = "12345".toCharArray();
		// cs[1] = "jfsldffds".toCharArray();
		// for(int i = 0; i < cs.length; i++){
		// for(int j = 0; j < cs[i].length; j++) System.out.println(cs[i][j] + "
		// ");
		// }
		int v = 2 ^ 31 - 3;
		System.out.println(v & -v);
		System.out.println(1 ^ 1 - 1);
		// System.out.println(int.class == Integer.class);
		// System.out.println(Arrays.toString(new int[]{1, 3}));
		// Integer[] i = {1, 2, 3};
		// Object[] x = i;
		// Integer[] j = (Integer[])x;
		// //x[0] = new Object();
		// j[0] = 2;
	}
}
