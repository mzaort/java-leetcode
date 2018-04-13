package googleCode;

import java.util.Arrays;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
    	if(board.length != 9 || board[0].length != 9) return false;
    	int[] bit = new int[9];
    	for(int i = 0; i < 9; i++){
    		Arrays.fill(bit, 1);
    		for(int j = 0; j < 9; j++){
    			if(board[i][j] != '.'){
    				int index = board[i][j] - '1';
    				if(index < 0 || index >= 9 || bit[index] == 0) return false;
    				bit[index] = 0;
    			}
    		}
    	}
    	for(int j = 0; j < 9; j++){
    		Arrays.fill(bit, 1);
    		for(int i = 0; i < 9; i++){
    			if(board[i][j] != '.'){
    				int index = board[i][j] - '1';
    				if(index < 0 || index >= 9 || bit[index] == 0) return false;
    				bit[index] = 0;
    			}
    		}
    	}
    	for(int k1 = 0; k1 < 9; k1 += 3){
    		for(int k2 = 0; k2 < 9; k2 += 3){
    			Arrays.fill(bit, 1);
    			for(int i = k1; i < k1 + 3; i++){
    				for(int j = k2; j < k2 + 3; j++){
    					if(board[i][j] != '.'){
    	    				int index = board[i][j] - '1';
    	    				if(index < 0 || index >= 9 || bit[index] == 0) return false;
    	    				bit[index] = 0;
    	    			}
    				}
    			}
    		}
    	}
    	return true;
    }
}
