package microsoft;

public class MatrixTransfer {

	public boolean isTransferable(int[][] mat){
		for(int i = 1; i < mat.length - 1; i++){
			for(int j = 1; j < mat[i].length - 1; j++){
				if(isDecreasable(mat, i, j)){
					dicrease(mat, i, j);
					return isTransferable(mat);
				}
			}
		}
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[i].length; j++){
				if(mat[i][j] != 0) return false;
			}
		}
		return true;
	}

	private void dicrease(int[][] mat, int i, int j) {
		mat[i][j]--;
		mat[i + 1][j]--;
		mat[i - 1][j]--;
		mat[i][j - 1]--;
		mat[i][j + 1]--;
	}

	private boolean isDecreasable(int[][] mat, int i, int j) {
		return mat[i][j] > 0 && mat[i + 1][j] > 0 && mat[i - 1][j] > 0
				&& mat[i][j - 1] > 0 && mat[i][j + 1] > 0;
	}
	
	public boolean isTransferable2(int[][] mat){
		for(int i = 1; i < mat.length - 1; i++){
			for(int j = 1; j < mat[i].length - 1; j++){
				if(mat[i - 1][j] != 0){
					if(mat[i + 1][j] < mat[i - 1][j] || mat[i][j] < mat[i - 1][j]
							|| mat[i][j - 1] < mat[i - 1][j] || mat[i][j + 1] < mat[i - 1][j]) return false;
					mat[i + 1][j] -= mat[i - 1][j];
					mat[i][j] -= mat[i - 1][j];
					mat[i][j - 1] -= mat[i - 1][j];
					mat[i][j + 1] -= mat[i - 1][j];
				}
			}
		}
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[i].length; j++){
				if(mat[i][j] != 0) return false;
			}
		}
		return true;
	}
}
