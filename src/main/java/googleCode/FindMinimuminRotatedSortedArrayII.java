package googleCode;

public class FindMinimuminRotatedSortedArrayII {
	public static void main(String[] args) {
		int[] A = {1, 3, 3};
		FindMinimuminRotatedSortedArrayII f2 = new FindMinimuminRotatedSortedArrayII();
		System.out.println(f2.findMin(A));
	}
	public int findMin(int[] A) {
        int i = 0, j = A.length - 1;
        while(i <= j){
        	if(i == j) return A[i];
        	if(i + 1 == j) return Math.min(A[i], A[j]);
        	int m = i + ((j - i) >>> 1);
        	if(A[m] == A[i]) i++;
        	else if(A[m] == A[j]) j--;
        	else if(A[m] < A[i] && A[m] < A[j]) j = m;
        	else if(A[m] > A[i] && A[m] > A[j]) i = m;
        	else return A[i];
        }
        return Integer.MAX_VALUE;
    }
	
	public int findMin2(int[] A) {
        int i = 0, j = A.length - 1;
        while(i <= j){
        	if(i == j) return A[i];
        	if(i + 1 == j) return Math.min(A[i], A[j]);
        	int m = i + ((j - i) >>> 1);
        	if(A[m] == A[i]) i++;
        	else if(A[m] == A[j]) j--;
        	else if(A[m] < A[j]) j = m;
        	else if(A[m] > A[j]) i = m;
        }
        return Integer.MAX_VALUE;
    }
}
