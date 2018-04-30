package googleCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber lcp = new LetterCombinationsofaPhoneNumber();
		System.out.println(lcp.letterCombinations("34"));
	}

	public List<String> letterCombinations(String digits) {
		char[][] table = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		return letterCombinations(table, digits, digits.length());
	}

	private List<String> letterCombinations(char[][] table, String digits, int length) {
		List<String> res = new ArrayList<String>();
		if (length == 0) {
			res.add("");
		} else {
			int index = digits.charAt(length - 1) - '0';
			for (String s : letterCombinations(table, digits, length - 1)) {
				for (int i = 0; i < table[index].length; i++) {
					res.add(s + table[index][i]);
				}
			}
		}
		return res;
	}

	public List<String> letterCombinations2(String digits) {
		char[][] table = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		List<String> res = new ArrayList<String>();
		letterCombinations2(res, table, "", digits, 0);
		return res;
	}

	private void letterCombinations2(List<String> res, char[][] table, String tmp, String digits, int cur) {
		if (cur == digits.length()) {
			res.add(tmp);
		} else {
			int index = digits.charAt(cur) - '0';
			for (int i = 0; i < table[index].length; i++)
				letterCombinations2(res, table, tmp + table[index][i], digits, cur + 1);
		}
	}

	public List<String> letterCombinations3(String digits) {
		char[][] table = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		List<String> res = new ArrayList<String>();
		res.add("");

		for (char ch : digits.toCharArray()) {
			List<String> tmp = new ArrayList<String>();
			for (String s : res) {
				for (char c : table[ch - '0']) {
					tmp.add(s + c);
				}
			}
			res = tmp;
		}
		return res;
	}
}
