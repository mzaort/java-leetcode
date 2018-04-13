package interview2015;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
    	isSolvable(board);
    }

	private boolean isSolvable(char[][] board) {
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board[i][j] == '.'){
					for(int k = 1; k <= 9; k++){
						board[i][j] = (char) ('0' + k);
						if(!isCollide(board, i, j) && isSolvable(board)) return true;
					}
					board[i][j] = '.';//当错误的时候需要变为原先的状态,否则，下一次判断board[i][j] == '.'将找不到。
					return false;
				}
			}
		}
		return true;
	}

	private boolean isCollide(char[][] board, int i, int j) {
		for(int k = 0; k < 9; k++) if((k != j && board[i][k] == board[i][j]) || (k != i && board[k][j] == board[i][j])) return true;
		for(int k1 = i / 3 * 3; k1 < i / 3 * 3 + 3; k1++){
			for(int k2 = j / 3 * 3; k2 < j / 3 * 3 + 3; k2++){
				if((!(k1 == i && k2 == j)) && board[k1][k2] == board[i][j]) return true;
			}
		}
		return false;
	}
}
