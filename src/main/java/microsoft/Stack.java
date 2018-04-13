package microsoft;

public class Stack {
	private int[] value;
	private int[] min;
	private int top;

	public Stack(int n) {
		if (n <= 0) {

		}
		value = new int[n];
		min = new int[n];
		top = -1;
	}

	public void push(int val) {
		if (top == value.length) {

		}
		value[++top] = val;
		if (top == 0) {
			min[top] = 0;
		} else {
			if (value[min[top - 1]] <= val) {
				min[top] = min[top - 1];
			} else {
				min[top] = top;
			}
		}
	}

	public int pop() {
		if (top == -1) {

		}
		int res = value[top--];
		return res;
	}

	public int min() {
		if (top == -1) {

		}
		return value[min[top]];
	}
	
	public static void main(String[] args) {
		Stack stk = new Stack(100);
		for(int i = 0; i < 5; i++){
			stk.push((int)(Math.random()*100));
			System.out.println(stk.value[stk.top]);
		}
		
		for(int i = 0; i < 4; i++){
			System.out.println(stk.min());
			stk.pop();
		}
	}
	
}