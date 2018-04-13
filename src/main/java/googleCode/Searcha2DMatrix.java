package googleCode;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0 || matrix[0].length == 0) return false;
    	int row = matrix.length, col = matrix[0].length;
    	int left = 0, right = row * col - 1;
    	while(left <= right){
    		int mid = left + ((right - left) >>> 1);
    		int x = mid / col, y = mid % col;
    		if(matrix[x][y] == target) return true;
    		else if(matrix[x][y] < target) left = mid + 1;
    		else right = mid - 1;
    	}
    	return false;
    }
}
