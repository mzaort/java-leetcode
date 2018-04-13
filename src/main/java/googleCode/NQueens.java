package googleCode;

import java.util.*;

public class NQueens {
    public List<String[]> solveNQueens(int n) {
    	assert(n > 0);
    	List<String[]> res = new ArrayList<String[]>();
    	dfs(res, new int[n], 0);
    	return res;
    }

	private void dfs(List<String[]> res, int[] board, int cur) {
		if(cur == board.length){
			StringBuilder sb = new StringBuilder(board.length);
			for(int i = 0; i < board.length; i++) sb.append('.');
			String[] strs = new String[board.length];
			for(int i = 0; i < board.length; i++){
				sb.setCharAt(board[i], 'Q');
				strs[i] = new String(sb);
				sb.setCharAt(board[i], '.');
			}
			res.add(strs);
		}else{
			for(int i = 0; i < board.length; i++){
				if (!isCollided(board, cur, i)) {
					board[cur] = i;
					dfs(res, board, cur + 1);
				}
			}
		}
	}
	
	private boolean isCollided(int[] board, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (board[k] == j || j - i == board[k] - k || j + i == board[k] + k) {
				return true;
			}
		}
		return false;
	}
	
	public List<String[]> solveNQueens2(int n){
		assert(n > 0);
		List<String[]> res = new ArrayList<String[]>();
		LinkedList<ArrayList<Integer>> stack = new LinkedList<ArrayList<Integer>>();
		stack.push(new ArrayList<Integer>(n));
		
		ArrayList<Integer> tmp = null;
		while((tmp = stack.poll()) != null){
			if(tmp.size() == n){
				String[] str = new String[n];
				StringBuilder sb = new StringBuilder(n);
				for(int i = 0; i < n; i++) sb.append('.');
				for(int i = 0; i < n; i++){
					sb.setCharAt(tmp.get(i), 'Q');
					str[i] = new String(sb);
					sb.setCharAt(tmp.get(i), '.');
				}
				res.add(str);				
			}else{
				for(int i = 0; i < n; i++){
					if(!isCollided(tmp, i)){
						ArrayList<Integer> list = new ArrayList<Integer>(tmp);
						list.add(i);
						stack.push(list);
					}
				}
			}
		}
		return res;
	}
	
	private boolean isCollided(ArrayList<Integer> list, int j) {
		for (int k = 0; k < list.size(); k++) {
			if (list.get(k) == j || j - list.size() == list.get(k) - k || j + list.size() == list.get(k) + k) {
				return true;
			}
		}
		return false;
	}
}
