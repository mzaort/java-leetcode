package googleCode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		RestoreIPAddresses ria = new RestoreIPAddresses();
		System.out.println(ria.restoreIpAddresses2("25525511135"));
	}

	public List<String> restoreIpAddresses(String s) {
		// only digits
		List<String> res = new ArrayList<String>();
		for (int i = 1; i <= s.length() - 3 && isValid(s, 0, i); i++) {
			for (int j = i + 1; j <= s.length() - 2 && isValid(s, i, j); j++) {
				for (int k = j + 1; k <= s.length() - 1 && isValid(s, j, k); k++) {
					if (isValid(s, k, s.length())) {
						res.add(s.substring(0, i) + "." + s.substring(i, j) + "." + s.substring(j, k) + "."
								+ s.substring(k));
					}
				}
			}
		}

		return res;
	}

	private boolean isValid(String s, int frm, int end) {
		switch (end - frm) {
		case 1:
			return true;
		case 2:
			return s.charAt(frm) != '0';
		case 3:
			return s.charAt(frm) != '0' && Integer.parseInt(s.substring(frm, end)) < 256;
		default:
			return false;
		}
	}

	public List<String> restoreIpAddresses2(String s) {
		List<String> res = new ArrayList<String>();
		restoreIpAddresses(res, "", s, 0, 4);
		return res;
	}

	private void restoreIpAddresses(List<String> res, String str, String s, int cur, int split) {
		if (split == 1) {
			if (isValid(s, cur, s.length())) res.add((str + "." + s.substring(cur)).substring(1));
		} else {
			for (int i = cur + 1; i <= cur + 3 && i <= s.length() - split + 1 && isValid(s, cur, i); i++) {
				restoreIpAddresses(res, str + "." + s.substring(cur, i), s, i, split - 1);
			}
		}
	}
}
