package solution;

import java.util.ArrayList;

public class RestoreIPAddress {
	public static void main(String[] args) {
		RestoreIPAddress ria = new RestoreIPAddress();
		System.out.println(ria.restoreIpAddresses("0279245587303"));
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return restoreIpAddresses(s, 4);
	}

	private ArrayList<String> restoreIpAddresses(String s, int i) {
		ArrayList<String> list = new ArrayList<String>();
		if (s.length() < i)
			return list;

		if (i == 1) {
			if (s.charAt(0) == '0' && s.length() > 1) {
				return list;
			}
			if (s.length() < 4 && Integer.parseInt(s) <= 255) {
				list.add(s);
			}
			return list;
		}

		if (s.length() > 1) {
			ArrayList<String> alist1 = restoreIpAddresses(s.substring(1), i - 1);
			if (alist1.size() != 0) {
				for (String e : alist1) {
					list.add(s.substring(0, 1) + "." + e);
				}
			}
		}

		if (s.charAt(0) == '0') {
			return list;
		}

		if (s.length() > 2) {
			ArrayList<String> alist2 = restoreIpAddresses(s.substring(2), i - 1);
			if (alist2.size() != 0) {
				for (String e : alist2) {
					list.add(s.substring(0, 2) + "." + e);
				}
			}
		}

		if (s.length() > 3) {
			String s2 = s.substring(0, 3);
			if (Integer.parseInt(s2) <= 255) {
				ArrayList<String> alist3 = restoreIpAddresses(s.substring(3),
						i - 1);
				if (alist3.size() != 0) {
					for (String e : alist3) {
						list.add(s.substring(0, 3) + "." + e);
					}
				}
			}
		}
		return list;
	}
}
