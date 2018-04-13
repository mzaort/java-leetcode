package solution;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cur = m + n - 1, acur = m - 1, bcur = n - 1;
        while(bcur >= 0 && acur >= 0){
        	if(A[acur] <= B[bcur]){
        		A[cur--] = B[bcur--];
        	}else{
        		A[cur--] = A[acur--];
        	}
        }
        while(bcur >= 0){
        	A[cur--] = B[bcur--];
        }
    }
}
