package googleapac;

import java.io.*;
import java.util.*;

public class SolutionB {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sin = new Scanner(new File("E:\\Document\\B-large-practice.in"));
		PrintWriter pwr = new PrintWriter(new File("test.out"));
		
		SolutionB st = new SolutionB();
		int t = Integer.parseInt(sin.nextLine());
		for(int k = 1; k <= t; k++){
			int n = sin.nextInt();
			String dir = sin.nextLine().trim();
			int[][] mat = new int[n][n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					mat[i][j] = sin.nextInt();
				}
			}
			st.solve2(dir, mat);
			pwr.println("Case #" + k + ":");
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					pwr.print(mat[i][j]);
					pwr.print(j != n - 1 ? " " : "\n");
				}
			}
		}
		
		sin.close();
		pwr.close();
	}
	
	public void solve2(String dir, int[][] mat) {
		int n = mat.length;
		for(int i = 0; i < n; i++){
			LinkedList<Integer> stack = new LinkedList<Integer>();
			boolean can = false;
			if(dir.equals("left")){
				for(int j = 0; j < n; j++){
					if(mat[i][j] != 0){
						if(!stack.isEmpty() && stack.peekLast() == mat[i][j] && can){
							stack.pollLast();
							stack.offerLast(mat[i][j] << 1);
							can = false;
						}else{
							stack.offerLast(mat[i][j]);
							can = true;
						}
					}
				}
				for(int j = 0; j < n; j++){
					Integer val = stack.pollFirst();
					mat[i][j] = val == null ? 0 : val;
				}
			}else if(dir.equals("right")){
				for(int j = n - 1; j >= 0; j--){
					if(mat[i][j] != 0){
						if(!stack.isEmpty() && stack.peekLast() == mat[i][j] && can){
							stack.pollLast();
							stack.offerLast(mat[i][j] << 1);
							can = false;
						}else{
							stack.offerLast(mat[i][j]);
							can = true;
						}
					}
				}
				for(int j = n - 1; j >= 0; j--){
					Integer val = stack.pollFirst();
					mat[i][j] = val == null ? 0 : val;
				}
			}else if(dir.equals("up")){
				for(int j = 0; j < n; j++){
					if(mat[j][i] != 0){
						if(!stack.isEmpty() && stack.peekLast() == mat[j][i] && can){
							stack.pollLast();
							stack.offerLast(mat[j][i] << 1);
							can = false;
						}else{
							stack.offerLast(mat[j][i]);
							can = true;
						}
						
					}
				}
				for(int j = 0; j < n; j++){
					Integer val = stack.poll();
					mat[j][i] = val == null ? 0 : val;
				}
			}else if(dir.equals("down")){
				for(int j = n - 1; j >= 0; j--){
					if(mat[j][i] != 0){
						if(!stack.isEmpty() && stack.peekLast() == mat[j][i] && can){
							stack.pollLast();
							stack.offerLast(mat[j][i] << 1);
							can = false;
						}else{
							stack.offerLast(mat[j][i]);
							can = true;
						}
						
					}
				}
				for(int j = n - 1; j >= 0; j--){
					Integer val = stack.poll();
					mat[j][i] = val == null ? 0 : val;
				}
			}
		}
	}

	public void solve(String dir, int[][] mat) {
		boolean row = dir.equals("left") || dir.equals("right");
		boolean reverse = dir.equals("right") || dir.equals("down");
				
		int len = mat.length;
		int[] cpy = new int[len];
		boolean[] newly = new boolean[len];
		for(int i = 0; i < len; i++){
			copyFrom(mat, i, cpy, row, reverse);
			dispose(cpy, newly);
			copyTo(mat, i, cpy, row, reverse);
		}
	}

	private void copyTo(int[][] mat, int i, int[] cpy, boolean row,
			boolean reverse) {
		int len = mat.length;
		if (row) {
			if (reverse) {
				for(int j = 0, k = len - 1; j < len; j++, k--)  mat[i][k] = cpy[j];
			} else {
				for(int j = 0, k = 0; j < len; j++, k++) mat[i][k] = cpy[j] ;
			}
		} else {
			if (reverse) {
				for(int j = 0, k = len - 1; j < len; j++, k--) mat[k][i] = cpy[j];
			} else {
				for(int j = 0, k = 0; j < len; j++, k++) mat[k][i] = cpy[j];
			}
		}
	}

	private void copyFrom(int[][] mat, int i, int[] cpy, boolean row,
			boolean reverse) {
		int len = mat.length;
		if (row) {
			if (reverse) {
				for(int j = 0, k = len - 1; j < len; j++, k--) cpy[j] = mat[i][k];
			} else {
				for(int j = 0, k = 0; j < len; j++, k++) cpy[j] = mat[i][k];
			}
		} else {
			if (reverse) {
				for(int j = 0, k = len - 1; j < len; j++, k--) cpy[j] = mat[k][i];
			} else {
				for(int j = 0, k = 0; j < len; j++, k++) cpy[j] = mat[k][i];
			}
		}
	}

	private void dispose(int[] A, boolean[] newly) {
		Arrays.fill(newly, false);
		for(int i = 1; i < A.length; i++){
			if(A[i] != 0){
				int j = i - 1;
				for(; j >= 0 && A[j] == 0; j--);
				if(j >= 0 && A[j] == A[i] && !newly[j]){
					A[j] <<= 1;
					A[i] = 0;
					newly[j] = true;
				}else{
					if(j + 1 != i){
						A[j + 1] = A[i];
						A[i] = 0;
					}
				}
			}
		}
	}
}
