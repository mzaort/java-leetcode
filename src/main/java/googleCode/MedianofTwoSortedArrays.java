package googleCode;

public class MedianofTwoSortedArrays {
	
	public static void main(String[] args) {
		MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
		int[] A = {1, 7, 9, 10, 11};
		int[] B = {2, 8, 13};
		System.out.println(mtsa.findMedianSortedArrays2(A, B));
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if((len & 1) == 0){
			int val1 = findKth(A, 0, A.length - 1, B, 0, B.length - 1, (len + 1) / 2);
			int val2 = findKth(A, 0, A.length - 1, B, 0, B.length - 1, (len + 3) / 2);
			return (0.0 + val1 + val2) / 2;
		}else{
			int val1 = findKth(A, 0, A.length - 1, B, 0, B.length - 1, (len + 1) / 2);
			return val1;
		}
	}

	private int findKth(int[] A, int afrm, int aend, int[] B, int bfrm, int bend, int k) {
		if(afrm > aend) return B[bfrm + k - 1];
		if(bfrm > bend) return A[afrm + k - 1];
		
		int alen = aend - afrm + 1, blen = bend - bfrm + 1;
		int len = alen + blen;
		int i = afrm + (alen * (k + 1)) / len - 1;
		int j = k + afrm + bfrm - 1 - i;
		
		long ai = (i < afrm) ? Long.MIN_VALUE : (i > aend ? Long.MAX_VALUE : A[i]);
		long ai_1 = (i - 1 < afrm) ? Long.MIN_VALUE : (i - 1 > aend ? Long.MAX_VALUE : A[i - 1]);
		long bj = (j < bfrm) ? Long.MIN_VALUE : (j > bend ? Long.MAX_VALUE : B[j]);
		long bj_1 = (j - 1 < bfrm) ? Long.MIN_VALUE : (j - 1 > bend ? Long.MAX_VALUE : B[j - 1]);
		if(ai >= bj_1 && ai <= bj) return A[i];
		if(bj >= ai_1 && bj <= ai) return B[j];
		if(ai < bj) return findKth(A, i + 1, aend, B, bfrm, j - 1, k - i + afrm - 1);
		else return findKth(A, afrm, i - 1, B, j + 1, bend, k - j + bfrm - 1);
	}
	
	public double findMedianSortedArrays2(int A[], int B[]) {
		int len = A.length + B.length;
		if((len & 1) == 0){
			int val1 = findKth2(A, 0, A.length - 1, B, 0, B.length - 1, (len + 1) / 2);
			int val2 = findKth2(A, 0, A.length - 1, B, 0, B.length - 1, (len + 3) / 2);
			return (0.0 + val1 + val2) / 2;
		}else{
			int val1 = findKth2(A, 0, A.length - 1, B, 0, B.length - 1, (len + 1) / 2);
			return val1;
		}
	}

	private int findKth2(int[] A, int afrm, int aend, int[] B, int bfrm, int bend, int k) {
		if(aend - afrm > bend - bfrm) return findKth2(B, bfrm, bend, A, afrm, aend, k);
		if(afrm > aend) return B[bfrm + k - 1];
		if(k == 1) return A[afrm] < B[bfrm] ? A[afrm] : B[bfrm];
		
		int min = aend - afrm + 1;
		if(min > k / 2) min = k / 2;
		int i = afrm + min - 1;
		int j = k - min + bfrm - 1;
		if(A[i] < B[j]) return findKth2(A, i + 1, aend, B, bfrm, j, k - min);
		else if(A[i] > B[j]) return findKth2(A, afrm, i, B, j + 1, bend, min);
		else return A[i];
	}
}
