package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SudokuChecker {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sin = new Scanner(new File("A-large-practice.in"));
		PrintWriter pwr = new PrintWriter(new File("A-large-practice.out"));
		int cnt = sin.nextInt();
		for(int k = 1; k <= cnt; k++){
			int step = sin.nextInt();
			int len = step * step;
			int[][] A = new int[len][len];
			for(int i = 0; i < len; i++){
				for(int j = 0; j < len; j++){
					A[i][j] = sin.nextInt();
				}
			}
			pwr.println("Case #" + k + ": " + (isValid(A) ? "Yes":"No"));
		}
		sin.close();
		pwr.close();
	}
	
	public static boolean isValid(int[][] A){
		int len = A.length;
		int step = (int) Math.sqrt(len);
		
		boolean[] flag = new boolean[len + 1];
		for(int i = 0; i < len; i++){
			Arrays.fill(flag, false);
			for(int j = 0; j < len; j++){
				if(A[i][j] < 1 || A[i][j] > len || flag[A[i][j]]) return false;
				flag[A[i][j]] = true;
			}
		}
		
		for(int j = 0; j < len; j++){
			Arrays.fill(flag, false);
			for(int i = 0; i < len; i++){
				if(A[i][j] < 1 || A[i][j] > len || flag[A[i][j]]) return false;
				flag[A[i][j]] = true;
			}
		}
		
		
		for(int k1 = 0; k1 < len; k1 += step){
			for(int k2 = 0; k2 < len; k2 += step){
				Arrays.fill(flag, false);
				for(int i = k1; i < k1 + step; i++){
					for(int j = k2; j < k2 + step; j++){
						if(A[i][j] < 1 || A[i][j] > len || flag[A[i][j]]) return false;
						flag[A[i][j]] = true;
					}
				}
			}
		}
		return true;
	}
}
