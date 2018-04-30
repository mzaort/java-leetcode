package solution;

import java.util.LinkedList;

public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid3("[]"));
		System.out.println(')' - '(');
		System.out.println(']' - '[');
		System.out.println('}' - '{');
	}

	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0) return true;
		LinkedList<Character> stack = new LinkedList<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				Character ch = stack.poll();
				if (ch == null) {
					return false;
				} else {
					switch (ch.charValue()) {
					case '(':
						if (c != ')') return false;
						break;
					case '[':
						if (c != ']') return false;
						break;
					case '{':
						if (c != '}') return false;
						break;
					default:
						return false;
					}
				}
			}
		}
		return stack.size() == 0;
	}

	public boolean isValid2(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0) return true;
		LinkedList<Character> stack = new LinkedList<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				Character ch = stack.poll();
				if (ch == null || c - ch.charValue() > 2) { return false; }
			}
		}

		return stack.size() == 0;
	}

	public boolean isValid3(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0) return true;

		char[] cstr = s.toCharArray();
		int top = -1;
		for (int i = 0; i < cstr.length; i++) {
			char c = cstr[i];
			if (c == '(' || c == '{' || c == '[') {
				cstr[++top] = c;
			} else if (c == ')' || c == '}' || c == ']') {
				if (top < 0 || c - cstr[top] > 2) { return false; }
				top--;
			} else {
				return false;
			}
		}
		return top == -1;
	}

	private boolean isMatch(char c, char d) {
		return (c == '(' && d == ')') || (c == '{' && d == '}' || (c == '[' && d == ']'));
	}
}
