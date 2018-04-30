package interview2018;

import java.util.ArrayList;
import java.util.LinkedList;

public class MiniParser {
	public NestedInteger deserialize(String s) {
		LinkedList<NestedInteger> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '[') stack.push(null);
			else if (ch == ']') {
				NestedInteger ni = new NestedInteger();
				ArrayList<NestedInteger> list = new ArrayList<>();
				NestedInteger top = null;
				while (!stack.isEmpty() && (top = stack.pop()) != null) {
					list.add(top);
				}
				for (int j = list.size() - 1; j >= 0; j--) {
					ni.add(list.get(j));
				}
				stack.push(ni);
			} else if (ch != ',') {
				int j = i + 1;
				for (; j < s.length() && !(s.charAt(j) == '[' || s.charAt(j) == ']' || s.charAt(j) == ','); j++);
				stack.push(new NestedInteger(Integer.parseInt(s.substring(i, j))));
				i = j - 1;
			}
		}
		return stack.peek();
	}
}
