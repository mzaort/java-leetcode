package solution;

public class MedianOfSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int cur = A.length + B.length;
		if(cur % 2 == 0){
			return (0.0 + findKthSmallest(A, 0, A.length, B, 0, B.length, cur / 2) + findKthSmallest(A, 0, A.length, B, 0, B.length, cur / 2 + 1)) / 2.0;
		}else{
			return findKthSmallest(A, 0, A.length, B, 0, B.length, cur / 2 + 1);
		}
	}

	private double findKthSmallest(int[] a, int i, int alen, int[] b, int j,
			int blen, int k) {
		if(i == alen) return b[j + k - 1];
		if(j == blen) return a[i + k - 1];
		int m = (alen - i) >> 1;
		int n = (blen - j) >> 1;
		if(m + n + 1 > k){
			if(a[i + m] < b[j + n]){
				return findKthSmallest(a, i, i + m, b, j, j + n, k);
			}else{
				
			}
		}else{
			if(a[i] < b[j]){
				
			}else{
				
			}
		}
		return 0;
	}

	
}
