package googleCode;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
    	if(A.length == 0) return 0;
    	int top = 0;
    	for(int i = 1; i < A.length; i++){
    		if(A[i] != A[top]) A[++top] = A[i];
    	}
    	return top + 1;
    }
}
