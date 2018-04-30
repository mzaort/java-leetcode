package solution;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber lcp = new LetterCombinationsofaPhoneNumber();
		System.out.println(lcp.letterCombinations2("234"));

		System.out.println('0' + 0);
		System.out.println('9' + 0);
	}

	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		if (digits.length() == 0) return res;
		char ch = digits.charAt(0);
		if (ch < '0' || ch > '9') return res;

		ArrayList<String> tmp = null;
		switch (ch) {
		case '0':
			tmp = letterCombinations(digits.substring(1));
			for (String e : tmp) {
				res.add("0");
				res.add(e);
			}
			break;
		case '7':
			tmp = letterCombinations(digits.substring(1));
			for (char i = 'p'; i <= 's'; i++) {
				for (String e : tmp) {
					res.add("" + i);
					res.add(e);
				}
			}
			break;
		case '8':
			tmp = letterCombinations(digits.substring(1));
			for (char i = 't'; i <= 'v'; i++) {
				for (String e : tmp) {
					res.add("" + i);
					res.add(e);
				}
			}
			break;
		case '9':
			tmp = letterCombinations(digits.substring(1));
			for (char i = 'w'; i <= 'z'; i++) {
				for (String e : tmp) {
					res.add("" + i);
					res.add(e);
				}
			}
			break;
		default:
			tmp = letterCombinations(digits.substring(1));
			char from = (char) ('a' + (ch - 'a') * 3);
			for (char i = from; i <= from + 2; i++) {
				for (String e : tmp) {
					res.add("" + i);
					res.add(e);
				}
			}
			break;
		}
		return res;
	}

	public ArrayList<String> letterCombinations2(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		res.add("");
		int len = digits.length();
		if (len == 0) return res;

		String[] str = { " ", "0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		for (int i = 0; i < len; i++) {
			int index = digits.charAt(i) - '0';
			ArrayList<String> tmp = new ArrayList<String>();
			for (int j = 0; j < str[index].length(); j++) {
				for (String s : res) {
					tmp.add(s + str[index].charAt(j));
				}
			}
			res = tmp;
		}
		return res;
	}
}
