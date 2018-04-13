package solution;

import java.util.ArrayList;

public class NQueens {
	
	public static void main(String[] args) {
		NQueens nq = new NQueens();
		System.out.println(nq.solveNQueens(1));
	}
	
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res = new ArrayList<String[]>();
        if(n <= 0) return res;
        
        int[] loc = new int[n];
        dfsQueues(res, loc, 0);
        
        return res;
    }

	private void dfsQueues(ArrayList<String[]> res, int[] loc, int cur) {
		if(cur == loc.length){
			String[] str = new String[cur];
			for(int i = 0; i < cur; i++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < cur; j++){
					sb.append('.');
				}
				sb.setCharAt(loc[i], 'Q');
				str[i] = new String(sb);
			}
			res.add(str);
		}else{
			for(int i = 0; i < loc.length; i++){
				if(!isCollide(loc, cur, i)){
					loc[cur] = i;
					dfsQueues(res, loc, cur + 1);
				}
			}
		}
	}

	private boolean isCollide(int[] loc, int cur, int i) {
		for(int j = 0; j < cur; j++){
			if(loc[j] == i) return true;
			if(loc[j] + j == cur + i) return true;
			if(loc[j] - j == i - cur) return true;
		}
		return false;
	}
}
