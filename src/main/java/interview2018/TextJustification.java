package interview2018;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		if (words.length == 0 || maxWidth < 1) return null;
		List<String> res = new ArrayList<>();

		for (int i = 0; i < words.length;) {
			int frm = i, count = words[i].length();
			for (i++; i < words.length
					&& count + 1 + words[i].length() <= maxWidth; count += 1 + words[i].length(), i++);
			if (i == frm + 1 || i == words.length) {
				int extra = maxWidth - count;
				if (i == frm + 1 && extra < 0) return null;
				StringBuilder sb = new StringBuilder();
				sb.append(words[frm]);
				for (int j = frm + 1; j < i; j++)
					sb.append(' ').append(words[j]);
				sb.append(spaceRepeat(extra));
				res.add(sb.toString());
			} else {
				int w = i - frm - 1, left = maxWidth - count;
				int space = 1 + left / w;
				int i1 = left % w;
				int d1 = i1 + frm;
				StringBuilder sb = new StringBuilder();
				sb.append(words[frm]);
				for (int j = frm + 1; j <= d1; j++)
					sb.append(spaceRepeat(space + 1)).append(words[j]);
				for (int j = d1 + 1; j < i; j++)
					sb.append(spaceRepeat(space)).append(words[j]);
				res.add(sb.toString());
			}
		}

		return res;
	}

	private String spaceRepeat(int i) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < i; j++)
			sb.append(' ');
		return sb.toString();
	}

	public static void main(String[] args) {
		TextJustification tjf = new TextJustification();
		String[] words = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
				"computer.", "Art", "is", "everything", "else", "we", "do" };
		tjf.fullJustify(words, 20).forEach(System.out::println);
		System.out.println();
	}
}
