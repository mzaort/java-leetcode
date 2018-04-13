package microsoft;

public class Stack2 {
	private int[] value;
	private int top;
	private int min;

	public Stack2(int n) {
		if (n <= 0) {

		}
		value = new int[n];
		top = -1;
	}

	public void push(int val) {
		if (top == value.length) {

		}		
		if (top == -1) {
			min = value[++top] = val;
		} else {
			if(val >= min){
				value[++top] = val;
			}else{
				value[++top] = 2 * val - min;
				min = val;
			}
		}
	}
	
	public int top(){
		if (top == -1) {

		}
		int res = 0;
		if(value[top] >= min){
			res = value[top];
		}else{
			res = min;
		}
		return res;
	}
	

	public int pop() {
		if (top == -1) {

		}
		int res = 0;
		if(value[top] >= min){
			res = value[top--];
		}else{
			res = min;
			min = 2 * min - value[top--];
		}
		return res;
	}

	public int min() {
		if (top == -1) {

		}
		return min;
	}
	
	public static void main(String[] args) {
		Stack2 stk = new Stack2(100);
		for(int i = 0; i < 5; i++){
			stk.push((int)(Math.random()*100));
			System.out.println(stk.top());
		}
		
		for(int i = 0; i < 4; i++){
			System.out.println(stk.min());
			stk.pop();
		}
	}
	
}