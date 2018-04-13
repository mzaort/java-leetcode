package microsoft;

import java.util.ArrayList;

public class StackSequence {
	
	public static void main(String[] args) {
		int push[] = {1,2,3,4,5};
		int pop[] = {4,5,3,2,1};
		StackSequence ss = new StackSequence();
		System.out.println(ss.isSequence(push, pop));
	}

	// unique integer without
	public boolean isSequence(int[] push, int[] pop) {
		int len = push.length;
		if (pop.length != len)
			return false;
		if (len == 0)
			return true;

		ArrayList<Integer> stack = new ArrayList<Integer>(len);
		int i = 0, j = 0;
		Integer top = null;
		while (i < len) {
			stack.add(push[i++]);
			while (stack.size() != 0 && (top = stack.get(stack.size() - 1)) != null && top == pop[j]) {
				stack.remove(stack.size() - 1);
				j++;
			}
		}
		return j == len;
	}
	public boolean isSequence2(int[] A, int[] B){
		if(A.length != B.length) return false;
		int j = 0;
		for(int i = 0, top = 0; i < A.length; i++){
			A[top++] = A[i];
			while(top != 0 && A[top - 1] == B[j]){
				top--;
				j++;
			}
		}
		return j == B.length;
	}
}