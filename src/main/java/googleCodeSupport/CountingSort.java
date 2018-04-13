package googleCodeSupport;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		CountingSort cs = new CountingSort();
		int[] A = { 0, 6, 7, 2, 5, 2, 3, 4, 1, 3, 2, 2, 7, 4 };
		int[] B = A.clone();
		cs.sort2(A, 8);
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) {
			if (A[i] != B[i])
				System.out.println("wrong");
		}
		System.out.println("right");
	}

	public void sort(int[] A, int k) {
		int[] n = new int[k];
		Arrays.fill(n, 0);
		for (int e : A) {
			n[e]++;
		}

		int[] B = new int[A.length];
		for (int i = 0, h = 0; i < k; i++) {
			for (int j = 0; j < n[i]; j++) {
				B[h++] = i;
			}
		}
		System.arraycopy(B, 0, A, 0, A.length);
	}

	public void sort2(int[] A, int k) {
		int[] n = new int[k];
		Arrays.fill(n, 0);
		for (int e : A){
			n[e]++;
		}
		for(int i = 1; i < k; i++){
			n[i] += n[i - 1];
		}
		
		int[] B = new int[A.length];
		for(int i = A.length - 1; i >= 0; i--){
			B[--n[A[i]]] = A[i];
		}
		System.arraycopy(B, 0, A, 0, A.length);
	}
}
