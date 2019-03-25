package interview2018;

import java.util.LinkedList;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		// -1 for (; -2 for );
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') stack.push(-1);
			else if (ch == ')') {
				if (stack.isEmpty() || stack.peek() == -2) stack.push(-2);
				else {
					Integer top = stack.poll();
					if (top == -1) stack.push(2);
					else if (top > 0) {
						if (stack.isEmpty() || stack.peek() == -2) {
							stack.push(top);
							stack.push(-2);
						} else {
							stack.poll();
							stack.push(top + 2);
						}
					}
					int count = 0;
					while (!stack.isEmpty() && (top = stack.peek()) > 0)
						count += stack.poll();
					if (count > 0) stack.push(count);
				}
			}
		}

		return Math.max(stack.stream().max(Integer::compare).orElse(0), 0);
	}
}
