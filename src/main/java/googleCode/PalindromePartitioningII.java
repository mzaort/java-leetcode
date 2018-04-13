package googleCode;

import java.util.LinkedList;

public class PalindromePartitioningII {
    public int minCut(String s) {
        return f(new Integer[s.length() + 1], 0, s);
    }

	private int f(Integer[] v, int i, String s) {
		if(v[i] == null){
			if(i == s.length()){
				v[i] = -1;
			}else{
				int min = s.length() - i - 1;
				for(int j = i; j < s.length(); j++){
					if(isPalindrome(s, i, j)){
						int cut = f(v, j + 1, s) + 1;
						if(cut < min) min = cut;
					}
				}
				v[i] = min;
			}
		}
		return v[i];
	}
	
	private boolean isPalindrome(String s, int i, int j) {
		for (; i <= j && s.charAt(i) == s.charAt(j); i++, j--);
		return i > j;
	}
	
	public int minCut2(String s) {
        int[] f = new int[s.length() + 1];
        f[s.length()] = -1;
        
        boolean[][] flag = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) flag[i][i] = true;
        for(int i = 0, j = 1; j < s.length(); i++, j++) flag[i][j] = s.charAt(i) == s.charAt(j);
        for(int gap = 2; gap < s.length(); gap++){
        	for(int i = 0, j = gap + i; j < s.length(); i++, j++)
        		flag[i][j] = flag[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        }
        for(int i = s.length() - 1; i >= 0; i--){
        	int min = s.length() - i - 1;
        	for(int j = i; j < s.length(); j++){
				if(flag[i][j]){
					int cut = f[j + 1] + 1;
					if(cut < min) min = cut;
				}
			}
			f[i] = min;
        }
        return f[0];
    }
	
	public int minCut3(String s){
		int len = s.length();
		if(len == 0) return -1;
		
		boolean[][] palin = new boolean[len][len];
		for(int i = 0; i < len; i++) palin[i][i] = true;
		for(int i = 0, j = 1; j < len; i++, j++) palin[i][j] = s.charAt(i) == s.charAt(j);
		for(int gap = 2; gap < len; gap++){
			for(int i = 0, j = i + gap; j < len; i++, j++)
				palin[i][j] = palin[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Integer[] f = new Integer[len];
		for(int i = 0; i < len; i++){
			if(palin[0][i]){
				queue.offer(i);
				f[i] = 1;
			}
		}
		Integer top = null;
		while((top = queue.poll()) != null){
			if(top == len - 1) return f[top] - 1;
			for(int frm = top + 1, i = frm; i < len; i++){
				if(palin[frm][i] && f[i] == null){
					f[i] = f[top] + 1;
					queue.offer(i);
				}
			}
		}
		return -1;
	}
}
