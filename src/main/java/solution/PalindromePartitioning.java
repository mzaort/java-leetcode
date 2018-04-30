package solution;

import java.util.ArrayList;

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("abk"));
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		return partition(s, 0);
	}

	private ArrayList<ArrayList<String>> partition(String s, int from) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (from != s.length()) {
			for (int i = from; i < s.length(); i++) {
				if (isPalidro(s, from, i)) {
					String sp = s.substring(from, i + 1);
					ArrayList<ArrayList<String>> tmp = partition(s, i + 1);
					if (tmp.size() == 0) {
						ArrayList<String> list = new ArrayList<String>();
						list.add(sp);
						res.add(list);
					} else {
						for (ArrayList<String> e : tmp) {
							ArrayList<String> list = new ArrayList<String>();
							list.add(sp);
							list.addAll(e);
							res.add(list);
						}
					}
				}
			}
		}
		return res;
	}

	private boolean isPalidro(String s, int from, int end) {
		while (from < end) {
			if (s.charAt(from) != s.charAt(end)) { return false; }
			from++;
			end--;
		}
		return true;
	}
}
