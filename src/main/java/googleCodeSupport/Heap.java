package googleCodeSupport;

public class Heap {
	public void sort(int[] A) {
		maxHeapify(A);
		for (int n = A.length - 1; n >= 1; n--) {
			swap(A, 0, n);
			maxHeapify(A, 0, n);
		}
	}

	private void maxHeapify(int[] A) {
		for(int i = (A.length - 2) / 2; i >= 0; i--){		
			maxHeapify(A, i, A.length);
		}
	}

	private void maxHeapify(int[] A, int cur, int len) {
		int val = A[cur];
		int i = cur;
		for (int j = 2 * i + 1; j < len; i = j, j = 2 * i + 1) {
			if (j + 1 < len && A[j] < A[j + 1])
				j++;
			if (A[j] > val) {
				A[i] = A[j];
			} else {
				break;
			}
		}
		A[i] = val;
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public int[] minTopK(int[] A, int k){
		assert(k > 0 && k <= A.length);
		int[] heap = new int[k];
		System.arraycopy(A, 0, heap, 0, k);
		maxHeapify(heap);
		for(int i = k; i < A.length; i++){
			if(A[i] < heap[0]){
				heap[0] = A[i];
				maxHeapify(heap, 0, heap.length);
			}
		}
		return heap;
	}
}
