package solution;

import java.util.ArrayList;

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis2(4));
	}

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		if (n <= 0) return res;
		else return generateParen(n, n);
	}

	public ArrayList<String> generateParen(int i, int j) {
		ArrayList<String> res = new ArrayList<String>();
		if (i == 0) {
			StringBuilder sb = new StringBuilder();
			for (int k = 0; k < j; k++) {
				sb.append(")");
			}
			res.add(new String(sb));
			return res;
		} else {
			if (i < j) {
				ArrayList<String> tmp = generateParen(i - 1, j);
				for (String e : tmp) {
					res.add("(" + e);
				}
				tmp = generateParen(i, j - 1);
				for (String e : tmp) {
					res.add(")" + e);
				}
			} else if (i == j) {
				ArrayList<String> tmp = generateParen(i - 1, j);
				for (String e : tmp) {
					res.add("(" + e);
				}
			}
			return res;

		}
	}

	public ArrayList<String> generateParen2(int i, int j) {
		ArrayList<String> res = new ArrayList<String>();
		if (i == 0) {
			StringBuilder sb = new StringBuilder();
			for (int k = 0; k < j; k++) {
				sb.append(")");
			}
			res.add(new String(sb));
			return res;
		} else if (i > j) {
			return res;
		} else {
			ArrayList<String> tmp = generateParen(i - 1, j);
			for (String e : tmp) {
				res.add("(" + e);
			}
			tmp = generateParen(i, j - 1);
			for (String e : tmp) {
				res.add(")" + e);
			}
			return res;
		}
	}

	public ArrayList<String> generateParenthesis2(int n) {
		if (n < 0) return null;
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		list.add("");
		res.add(list);
		list = new ArrayList<String>();
		list.add("()");
		res.add(list);

		for (int i = 2; i <= n; i++) {
			list = new ArrayList<String>();
			for (int j = 0; j < i; j++) {
				for (String s1 : res.get(j)) {
					for (String s2 : res.get(i - j - 1)) {
						list.add("(" + s1 + ")" + s2);
					}
				}
			}
			res.add(list);
		}
		return res.get(n);
	}

}
