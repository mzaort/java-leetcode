package googleCode;

import java.util.Arrays;
import java.util.LinkedList;

public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		char[][] board = {"OO".toCharArray(),"OO".toCharArray()};
		sr.solve2(board);
		for(int i = 0; i < board.length; i++) System.out.println(Arrays.toString(board[i]));
	}
	public void solve2(char[][] board) {
    	if(board.length == 0 || board[0].length == 0) return;
    	int row = board.length, col = board[0].length;
    	for(int i = 0; i < row; i++){
			if (board[i][0] == 'O')	bfsMarkZ(board, i, 0);
			if (board[i][col - 1] == 'O')	bfsMarkZ(board, i, col - 1);
    	}
    	for(int j = 0; j < col; j++){
			if (board[0][j] == 'O')	bfsMarkZ(board, 0, j);
			if (board[row - 1][j] == 'O')	bfsMarkZ(board, row - 1, j);
    	}
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			if(board[i][j] == 'O'){
    				board[i][j] = 'X';
    			}else if(board[i][j] == 'Z'){
    				board[i][j] = 'O';
    			}
    		}
    	}
    }
	
    private void bfsMarkZ(char[][] board, int i, int j) {
		LinkedList<Pair<Integer>> queue = new LinkedList<Pair<Integer>>();
		queue.add(new Pair<Integer>(i, j));
		board[i][j] = 'Z';
		
		Pair<Integer> front = null;
		while((front = queue.poll()) != null){
			int x = front.x, y = front.y;
			if(x + 1 < board.length && board[x + 1][y] == 'O'){
				queue.add(new Pair<Integer>(x + 1, y));
				board[x + 1][y] = 'Z';
			}
			if(x - 1 >= 0 && board[x - 1][y] == 'O'){
				queue.add(new Pair<Integer>(x - 1, y));
				board[x - 1][y] = 'Z';
			}
			if(y + 1 < board[i].length && board[x][y + 1] == 'O'){
				queue.add(new Pair<Integer>(x, y + 1));
				board[x][y + 1] = 'Z';
			}
			if(y - 1 >= 0 && board[x][y - 1] == 'O'){
				queue.add(new Pair<Integer>(x, y - 1));
				board[x][y - 1] = 'Z';
			}
		}
	}

    class Pair<T>{
    	T x;
    	T y;
    	public Pair(){
    		super();
    	}
		public Pair(T x, T y) {
			super();
			this.x = x;
			this.y = y;
		}
		public T getX() {
			return x;
		}
		public void setX(T x) {
			this.x = x;
		}
		public T getY() {
			return y;
		}
		public void setY(T y) {
			this.y = y;
		}
    }
	public void solve(char[][] board) {
    	if(board.length == 0 || board[0].length == 0) return;
    	int row = board.length, col = board[0].length;
    	for(int i = 0; i < row; i++){
			if (board[i][0] == 'O')	dfsMarkZ(board, i, 0);
			if (board[i][col - 1] == 'O')	dfsMarkZ(board, i, col - 1);
    	}
    	for(int j = 0; j < col; j++){
			if (board[0][j] == 'O')	dfsMarkZ(board, 0, j);
			if (board[row - 1][j] == 'O')	dfsMarkZ(board, row - 1, j);
    	}
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			if(board[i][j] == 'O'){
    				board[i][j] = 'X';
    			}else if(board[i][j] == 'Z'){
    				board[i][j] = 'O';
    			}
    		}
    	}
    }

	private void dfsMarkZ(char[][] board, int i, int j) {
		board[i][j] = 'Z';
		if(i + 1 < board.length && board[i + 1][j] == 'O') dfsMarkZ(board, i + 1, j);
		if(i - 1 >= 0 && board[i - 1][j] == 'O') dfsMarkZ(board, i - 1, j);
		if(j + 1 < board[i].length && board[i][j + 1] == 'O') dfsMarkZ(board, i, j + 1);
		if(j - 1 >= 0 && board[i][j - 1] == 'O') dfsMarkZ(board, i, j - 1);
	}
}
