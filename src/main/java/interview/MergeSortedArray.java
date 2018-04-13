package interview;
public class MergeSortedArray{
	
	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] A = {1, 1, 1, 1, 1, 1, 1, 1, 1};
		msa.merge(A, 0, 2, A.length - 1);
		for(int e : A){
			System.out.println(e);
		}
	}
	
	public void merge2(int[] A, int frm, int mid, int end){
		if(frm > mid || mid + 1 > end) return;
		int i = search(A, frm, mid, A[mid + 1]);
		int j = search(A, mid + 1, end, A[i]);
		shiftRight(A, i, j - 1, j - mid - 1);
		merge2(A, i + j - mid, j - 1, end);
	}
	
	private void shiftRight(int[] a, int i, int j, int k) {
		if(k == 0 || j - i + 1 == 0) return;
		k = k % (j - i + 1);
		reverse(a, i, j - k);
		reverse(a, j - k + 1, j);
		reverse(a, i, j);
	}

	private void reverse(int[] a, int i, int j) {
		for(; i < j; i++, j--){
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}

	public void merge(int[] A, int frm, int mid, int end){
		if(frm > mid || mid + 1 > end) return;
		int i = search(A, frm, mid, A[mid + 1]);
		int j = search(A, mid + 1, end, A[i]);
		backSeat(A, i, j, mid);
		merge(A, i + j - mid, j - 1, end);
	}

	private void backSeat(int[] A, int i, int j, int mid) {
		int shift1 = j - mid - 1, shift2 = mid - i + 1;
		if(shift1 == 0 || shift2 == 0) return;
		int sum = shift1 + shift2;
		int min = shift1 > shift2 ? shift2 : shift1;
		if(sum % min == 0){
			int dul = sum / min;
			for(int k = i; k < i + dul; k++){
				int tmp = A[k], loc = k;
				for(int h = 0; h < min; h++){
					int want = loc <= mid ? loc + shift1 : loc - shift2;
					int wvalue = A[want];
					A[want] = tmp;
					tmp = wvalue;
					loc = want;
				}
			}
		}else{
			int tmp = A[i], loc = i;
			for(int k = 0; k < j - i; k++){
				int want = loc <= mid ? loc + shift1 : loc - shift2;
				int wvalue = A[want];
				A[want] = tmp;
				tmp = wvalue;
				loc = want;
			}
		}		
	}

	private int search(int[] a, int frm, int end, int target) {
		while(frm <= end){
			int mid = frm + ((end - frm) >> 1);
			if(a[mid] == target){
				return mid;
			}else if(a[mid] > target){
				end = mid - 1;
			}else{
				frm = mid + 1;
			}
		}
		return frm;
	}
}