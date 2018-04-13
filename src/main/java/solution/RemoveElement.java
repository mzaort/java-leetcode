package solution;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cur = 0, len = A.length;
        for(int i = 0; i < len; i++){
        	if(A[i] != elem){
        		A[cur++] = A[i];
        	}
        }
        return cur;
    }
}
