package interview2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionAddOperators {

	public List<String> addOperators3(String num, int target) {
		List<String> res = new ArrayList<>();
		trickyDfs(res, num, target, "", 0, 0);
		return res;
	}

	private void trickyDfs(List<String> res, String num, int target, String tmp, long currRes, long prevNum) {
		if (num.length() == 0) {
			if (currRes == target) res.add(tmp);
		} else {
			for (int i = 1; i <= num.length(); i++) {
				String currStr = num.substring(0, i);
				if (i > 1 && currStr.charAt(0) == '0') return;
				long currNum = Long.parseLong(currStr);
				String next = num.substring(i);
				if (tmp.length() != 0) {
					trickyDfs(res, next, target, tmp + "*" + currNum, (currRes - prevNum) + prevNum * currNum,
							prevNum * currNum);
					trickyDfs(res, next, target, tmp + "+" + currNum, currRes + currNum, currNum);
					trickyDfs(res, next, target, tmp + "-" + currNum, currRes - currNum, -currNum);
				} else {
					trickyDfs(res, next, target, currStr, currNum, currNum);
				}
			}
		}
	}

	public List<String> addOperators2(String num, int target) {
		List<String> result = new ArrayList<>();
		greedyDfs(result, "", num, num.length() - 1, target);
		return result;
	}

	private void greedyDfs(List<String> result, String suffix, String num, int e, long target) {
		if (e < 0) {
			if (target == 0) result.add(suffix);
		} else {
			for (int i = e - 1; i >= -1; i--) {
				for (int j = 0, max = 1 << (e - (i + 1)); j < max; j++) {
					String sfx = buildMultiplySfx(num, i + 1, e, j);
					if (isValidSfx(sfx)) {
						long value = calculateSfx(sfx);
						if (i == -1) {
							greedyDfs(result, sfx + suffix, num, i, target - value);
						} else {
							greedyDfs(result, '-' + sfx + suffix, num, i, target + value);
							greedyDfs(result, '+' + sfx + suffix, num, i, target - value);
						}
					}
				}
			}

		}
	}

	private long calculateSfx(String sfx) {
		long result = 1;
		int i = 0;
		while (i < sfx.length()) {
			int j = i + 1;
			for (; j < sfx.length() && sfx.charAt(j) != '*'; j++);
			result *= Long.valueOf(sfx.substring(i, j));
			i = j + 1;
		}
		return result;
	}

	private boolean isValidSfx(String sfx) {
		for (int i = 0; i < sfx.length(); i++) {
			if (sfx.charAt(i) == '0') {
				if (i + 1 < sfx.length() && sfx.charAt(i + 1) != '*') return false;
			} else if (sfx.charAt(i) != '*') {
				for (; i < sfx.length() && sfx.charAt(i) != '*'; i++);
			}
		}
		return true;
	}

	private String buildMultiplySfx(String num, int frm, int end, int count) {
		StringBuilder sb = new StringBuilder();
		sb.append(num.charAt(frm));
		for (int i = frm + 1; i <= end; i++) {
			if (count % 2 == 1) sb.append("*");
			sb.append(num.charAt(i));
			count >>>= 1;
		}
		return sb.toString();
	}

	public static final String ops = "+-*";

	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		dfs(result, new ArrayList<String>(), num, 0, target);
		return result;
	}

	private void dfs(List<String> result, List<String> list, String num, int i, int target) {
		if (i == num.length()) {
			if (calculate(list) == target) {
				result.add(list.stream().collect(Collectors.joining()));
			}
		} else {
			// operand +|-|*
			int splitMax = num.charAt(i) == '0' ? Math.min(num.length() - 1, i + 1) : num.length() - 1;
			for (int j = i + 1; j <= splitMax; j++) {
				for (int k = 0; k < ops.length(); k++) {
					list.add(num.substring(i, j));
					list.add(String.valueOf(ops.charAt(k)));
					dfs(result, list, num, j, target);
					list.remove(list.size() - 1);
					list.remove(list.size() - 1);
				}
			}
			// operand
			if (num.charAt(i) != '0' || i == num.length() - 1) {
				list.add(num.substring(i));
				dfs(result, list, num, num.length(), target);
				list.remove(list.size() - 1);
			}
		}
	}

	private int calculate(List<String> list) {
		LinkedList<String> operands = new LinkedList<String>();
		LinkedList<String> operators = new LinkedList<String>();

		for (int i = 0; i < list.size(); i++) {
			String op = list.get(i);
			if (ops.indexOf(op) >= 0) {
				while (operators.size() > 0 && compare(operators.peek(), op) >= 0) {
					String op2 = operands.pop();
					String op1 = operands.pop();
					operands.push(String.valueOf(calc(op1, op2, operators.pop())));
				}
				operators.push(op);
			} else {
				operands.push(op);
			}
		}
		while (!operators.isEmpty()) {
			String op2 = operands.pop();
			String op1 = operands.pop();
			operands.push(String.valueOf(calc(op1, op2, operators.pop())));
		}
		return operands.isEmpty() ? Integer.MAX_VALUE : Long.valueOf(operands.get(0)).intValue();
	}

	private int compare(String operator1, String operator2) {
		if (operator1.equals(operator2)) return 0;
		else if (operator2.equals("+") || operator2.equals("-")) return 1;
		else return -1;
	}

	private int calc(String op1, String op2, String op) {
		long result = 0;
		long num1 = Long.parseLong(op1);
		long num2 = Long.parseLong(op2);
		if (op.equals("+")) result = num1 + num2;
		else if (op.equals("-")) result = num1 - num2;
		else result = num1 * num2;
		return (int) result;
	}

	public static final void main(String[] args) {
		ExpressionAddOperators eao = new ExpressionAddOperators();
		System.out.println(eao.addOperators2("232", 8));
	}
}
