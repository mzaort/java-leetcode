package googleCode;

import java.util.LinkedList;

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("./.."));
	}

	public String simplifyPath(String path) {
		String[] strs = path.trim().split("/");
		LinkedList<String> stack = new LinkedList<String>();
		if (path.length() > 0 && path.charAt(0) == '/') stack.push("/");
		String top = null;
		for (String e : strs) {
			if (e.equals("")) {
				continue;
			} else if (e.equals("..")) {
				top = stack.peek();
				if (top == null || top.equals("..")) {
					stack.push(e);
				} else if (top.equals(".")) {
					stack.poll();
					stack.push(e);
				} else if (top.equals("/")) {

				} else {
					stack.poll();
				}
			} else if (e.equals(".")) {
				top = stack.peek();
				if (top == null) {
					stack.push(e);
				}
			} else {
				stack.push(e);
			}
		}
		StringBuilder sb = new StringBuilder();
		while ((top = stack.pollLast()) != null) {
			sb.append(top);
			if (!top.equals("/")) sb.append("/");
		}
		if (sb.length() > 1) return new String(sb.substring(0, sb.length() - 1));
		return new String(sb);
	}
}
