package googleCode;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = {{'a', 'a'}};
		String word = "aaa";
		System.out.println(ws.exist(board, word));
	}
    public boolean exist(char[][] board, String word) {
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[i].length; j++){
    			if(exist(new HashSet<Position>(), board, new Position(i, j), word, 0))
    				return true;
    		}
    	}
    	return false;
    }
	private boolean exist(Set<Position> set, char[][] board,
			Position pos, String word, int cur) {
		if(cur == word.length()) return true;
		if(!isValid(board, pos) || word.charAt(cur) != board[pos.x][pos.y] || set.contains(pos)) return false;
		set.add(pos);
		if(exist(set, board, pos.right(), word, cur + 1)) return true;
		if(exist(set, board, pos.down(), word, cur + 1)) return true;
		if(exist(set, board, pos.left(), word, cur + 1)) return true;
		if(exist(set, board, pos.up(), word, cur + 1)) return true;
		set.remove(pos);
		return false;
	}
	private boolean isValid(char[][] board, Position pos) {
		return pos.x >= 0 && pos.x < board.length && pos.y >= 0 && pos.y < board[pos.x].length;
	}
	
	class Position{
		int x;
		int y;
		Position(){
			
		}
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			Position other = (Position) obj;
			if (x != other.x) return false;
			if (y != other.y) return false;
			return true;
		}
		public Position right() {
			return new Position(x, y + 1);
		}
		public Position down() {
			return new Position(x + 1, y);
		}
		public Position left() {
			return new Position(x, y - 1);
		}
		public Position up() {
			return new Position(x - 1, y);
		}
	}
}
