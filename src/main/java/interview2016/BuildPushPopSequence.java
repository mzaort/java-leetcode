package interview2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BuildPushPopSequence {

	public static void main(String[] args) {
		BuildPushPopSequence bpps = new BuildPushPopSequence();
		System.out.println(bpps.convert2("", "").size());
	}

	public List<String> convert(String frm, String to) {
		List<String> list = new ArrayList<>();
		if (frm != null && to != null && frm.length() == to.length()) {
			convert(list, new StringBuilder(), frm, 0, to, 0, new LinkedList<Character>());
		}
		return list;
	}

	public List<String> convert2(String frm, String to) {
		List<String> list = new ArrayList<>();
		if (frm != null && to != null && frm.length() == to.length()) {
			convert2(list, "", frm, 0, to, 0, "");
		}
		return list;
	}

	public List<String> convert3(String frm, String to) {
		if (frm != null && to != null && frm.length() == to.length()) { return convert3(frm, 0, to, 0, frm.length()); }
		return new ArrayList<String>();
	}

	private List<String> convert3(String frm, int i, String to, int j, int length) {
		List<String> res = new ArrayList<String>();
		if (length == 0) {
			res.add("");
			return res;
		} else {
			char ch = frm.charAt(i);
			int k;
			for (k = j; k < j + length; k++) {
				if (to.charAt(k) == ch) {
					List<String> sublist = convert3(frm, i + 1, to, j, k - j);
					List<String> sublist2 = convert3(frm, i + k - j + 1, to, j + 1, length - k + j - 1);

					for (String e1 : sublist) {
						for (String e2 : sublist2) {
							res.add('i' + e1 + 'o' + e2);
						}
					}
				}
			}
			return res;
		}
	}

	private void convert2(List<String> list, String seq, String frm, int i, String to, int j, String stack) {
		if (i == frm.length()) {
			if (to.substring(j).equals(stack)) {
				char[] crs = new char[stack.length()];
				Arrays.fill(crs, 'o');
				seq += new String(crs);
				list.add(seq);
			}
		} else {
			convert2(list, seq + 'i', frm, i + 1, to, j, frm.charAt(i) + stack);
			if (stack.length() > 0 && to.charAt(j) == stack.charAt(0)) {
				convert2(list, seq + 'o', frm, i, to, j + 1, stack.substring(1));
			}
		}
	}

	private void convert(List<String> list, StringBuilder stringBuilder, String frm, int i, String to, int j,
			LinkedList<Character> stack) {
		if (i >= frm.length()) {
			ListIterator<Character> iterator = stack.listIterator();
			boolean match = true;
			while (iterator.hasNext() && match) {
				if (j > to.length() || to.charAt(j) != iterator.next().charValue()) match = false;
				j++;
			}
			match = match && j == to.length();
			if (match) {
				char[] chrs = new char[stack.size()];
				Arrays.fill(chrs, 'o');
				list.add(stringBuilder + new String(chrs));
			}
		} else {
			stringBuilder.append('i');
			stack.push(frm.charAt(i));
			convert(list, stringBuilder, frm, i + 1, to, j, stack);
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			stack.poll();
			if (stack.size() > 0 && j < to.length() && to.charAt(j) == stack.peek().charValue()) {
				stringBuilder.append('o');
				Character ch = stack.poll();
				convert(list, stringBuilder, frm, i, to, j + 1, stack);
				stringBuilder.deleteCharAt(stringBuilder.length() - 1);
				stack.push(ch);
			}
		}
	}
}
