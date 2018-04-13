package solution;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int x = matrix.length, y = matrix[0].length;
        int left = 0, right = x * y - 1;
        while(left <= right){
        	int mid = (left + right) >>> 1;
        	int locx = mid / y;
        	int locy = mid % y;
        	if(matrix[locx][locy] < target){
        		left = mid + 1;
        	}else if(matrix[locx][locy] > target){
        		right = mid - 1;
        	}else{
        		return true;
        	}
        }
        return false;
    }
}
