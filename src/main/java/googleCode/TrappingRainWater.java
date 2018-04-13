package googleCode;

import java.util.LinkedList;

public class TrappingRainWater {
	
	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		System.out.println(trw.trap3(new int[]{3 ,0, 0, 3}));
	}
    public int trap(int[] A) {
    	int max = 0;
    	for(int i = 0; i < A.length; i++) if(max < A[i]) max = A[i];
    	
    	int left = 0, right = A.length - 1;
    	for(; left < A.length && A[left] != max; left++);
    	for(; right >= 0 && A[right] != max; right--);
    	
    	int res = 0;
    	int low = 0;
    	for(int i = 0; i < left; i++){
    		if(A[i] < low) res += low - A[i];
    		else low = A[i];
    	}
    	low = 0;
    	for(int i = A.length - 1; i > right; i--){
    		if(A[i] < low) res += low - A[i];
    		else low = A[i];
    	}
    	for(int i = left + 1; i < right; i++){
    		res += max - A[i];
    	}
    	return res;
    }
    
    //wrong
    public int trap2(int[] A) {
    	class Pair{
    		int height;
    		int pos;
			public Pair(int height, int pos) {
				super();
				this.height = height;
				this.pos = pos;
			}
    	}
    	int res = 0;
    	LinkedList<Pair> stack = new LinkedList<Pair>();
		for (int i = 0; i < A.length; i++) {
			Pair top = null;
			int height = 0;
			while ((top = stack.peek()) != null && top.height <= A[i]) {
				res += (i - top.pos - 1) * (top.height - height);
				height = top.height;
				stack.poll();
			}
			stack.push(new Pair(A[i], i));
		}
    	return res;
    }
    
    public int trap3(int[] A) {
    	class Pair{
    		int height;
    		int pos;
			public Pair(int height, int pos) {
				super();
				this.height = height;
				this.pos = pos;
			}
    	}
    	int res = 0;
    	LinkedList<Pair> stack = new LinkedList<Pair>();
		for (int i = 0; i < A.length; i++) {
			Pair top = null;
			int height = 0;
			while ((top = stack.peek()) != null && top.height < A[i]) {
				res += (i - top.pos - 1) * (top.height - height);
				height = top.height;
				stack.poll();
			}
			if((top = stack.peek()) != null) res += (i - top.pos - 1) * (A[i] - height);
			stack.push(new Pair(A[i], i));
		}
    	return res;
    }
}
