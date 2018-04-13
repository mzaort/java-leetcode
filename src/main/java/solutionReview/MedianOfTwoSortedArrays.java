package solutionReview;
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
    	if (A.length == 0) {
			if (B.length % 2 == 0) {
				return (B[B.length / 2] + B[B.length / 2 - 1]) / 2.0;
			} else {
				return B[B.length / 2];
			}
		}
		
		if (B.length == 0) {
			if (A.length % 2 == 0) {
				return (A[A.length / 2] + A[A.length / 2 - 1]) / 2.0;
			} else {
				return A[A.length / 2];
			}
		}
        
        if (A.length == 1 && B.length == 1) {
            return (A[0] + B[0]) / 2.0;
        }
        
		int sizeSum = A.length + B.length;
		if (sizeSum % 2 == 0) {
			return (findMedianSortedArrays(A, B, sizeSum / 2) + findMedianSortedArrays(A, B, sizeSum / 2 + 1)) / 2;
		} else {
			return findMedianSortedArrays(A, B, (sizeSum + 1) / 2);
		}
    }
	
	public double findMedianSortedArrays(int A[], int B[], int k) {
        int pa = Math.min(A.length, k - 1);
        int delta = (pa + 1) / 2;
        return findKthSmallest(A, B, pa, delta, k);
    }
    
    public int findKthSmallest(int[] A, int[] B, int pa, int delta, int k) {
    	int pb = (k - 1) - pa;
		int Ai_1 = ((pa == 0) ? Integer.MIN_VALUE : A[pa-1]);
		int Bj_1 = ((pb == 0) ? Integer.MIN_VALUE : B[pb-1]);
		int Ai   = ((pa == A.length) ? Integer.MAX_VALUE : A[pa]);
		int Bj   = ((pb == B.length) ? Integer.MAX_VALUE : B[pb]);
		
		if (Bj_1 <= Ai && Ai <= Bj) return Ai;
		if (Ai_1 <= Bj && Bj <= Ai) return Bj;
		
		if (Ai > Bj) {
			pa = pa - delta;
			if (((k - 1) - pa) > B.length) {
				pa = k - 1 - B.length;
			}
		} else {
			pa = pa + delta;
			if (pa > Math.min(A.length, k - 1)) {
				pa = Math.min(A.length, k - 1);
			}
		}
		return findKthSmallest(A, B, pa, (delta + 1) / 2, k);	
	}
}