package googleCode;

public class FirstMissingPositive {
	
	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		System.out.println(fmp.firstMissingPositive2(new int[]{3,-1,2,1}));
	}
    public int firstMissingPositive(int[] A) {
    	for(int i = 0; i < A.length; i++){
    		if(A[i] != i + 1 && A[i] >= 1 && A[i] <= A.length){
    			int tmp = A[i];
    			int k = A[i] - 1;
    			while(k != i && k >= 0 && k < A.length && A[k] != k + 1){
    				int val = A[k];
    				A[k] = tmp;
    				tmp = val;
    				k = tmp - 1;
    			}
    			A[i] = tmp;
    		}
    	}
    	int cur = 0;
    	for(; cur < A.length && A[cur] == cur + 1; cur++);
    	return cur + 1;
    }
    
    public int firstMissingPositive2(int[] A) {
    	for(int i = 0; i < A.length;){
    		if(A[i] != i + 1 && A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i]){
    			swap(A, i, A[i] - 1);
    		}else{
    			i++;
    		}
    	}
    	int cur = 0;
    	for(; cur < A.length && A[cur] == cur + 1; cur++);
    	return cur + 1;
    }
	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
