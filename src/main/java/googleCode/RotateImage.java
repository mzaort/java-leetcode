package googleCode;

public class RotateImage {
	
	public static void main(String[] args) {
		
	}
	
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
    	for(int i = 0, k = n - 1; i < n; i++, k--){
    		for(int j = i; j < k; j++){
    			int tmp = matrix[i][j];
    			matrix[i][j] = matrix[n - 1 - j][i];
    			matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
    			matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
    			matrix[j][n - 1 - i] = tmp;
    		}
    	}
    }
}
