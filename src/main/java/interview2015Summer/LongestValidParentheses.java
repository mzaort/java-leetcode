package interview2015Summer;

import java.util.LinkedList;

public class LongestValidParentheses {
	public int longestValidParentheses(String s){
		int res = 0;
		LinkedList<Character> cstack = new LinkedList<>();
		LinkedList<Integer> istack = new LinkedList<>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				cstack.offer('(');
				istack.offer(i);
			}else{
				Character val = null;
				if((val = cstack.peek()) == null || val == ')'){
					cstack.clear();
					istack.clear();
					cstack.offer(')');
					istack.offer(i);
				}else{
					cstack.poll();
					istack.poll();
					res = Math.max(res, i - (istack.isEmpty() ? -1 : istack.peek()));
				}
			}
		}
		return res;
	}
}
