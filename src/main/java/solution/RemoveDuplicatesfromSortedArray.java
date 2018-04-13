package solution;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0;
        int previous = A[0] + 1;
        int cur = 0;
        for(int i = 0; i < A.length; i++){
        	if(A[i] != previous){
        		A[cur++] = A[i];
        		previous = A[i];
        	}
        }
        return cur;
    }
}
