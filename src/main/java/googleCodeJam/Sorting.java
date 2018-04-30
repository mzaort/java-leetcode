package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sorting {
	public static void main(String[] args) throws FileNotFoundException {
		String[] infile = { "test.in", "C-small-practice.in", "C-large-practice.in" };
		String[] outfile = { "test.out", "C-small-practice.out", "C-large-practice.out" };
		Scanner sin = new Scanner(new File(infile[2]));
		PrintWriter pwr = new PrintWriter(new File(outfile[2]));
		Sorting st = new Sorting();
		int cnt = sin.nextInt();
		for (int k = 1; k <= cnt; k++) {
			int n = sin.nextInt();
			int[] values = new int[n];
			for (int i = 0; i < n; i++)
				values[i] = sin.nextInt();
			st.sort(values);
			String res = st.toString(values);
			pwr.println("Case #" + k + ": " + res);
		}
		sin.close();
		pwr.close();
	}

	public String toString(int[] values) {
		StringBuilder sb = new StringBuilder();
		for (int e : values)
			sb.append(e + " ");
		return sb.length() == 0 ? "" : new String(sb.substring(0, sb.length() - 1));
	}

	public void sort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int val = A[i];
			int cur = i;
			if ((val & 1) == 1) {
				for (int j = i - 1; j >= 0; j--) {
					if ((A[j] & 1) == 1) {
						if (A[j] > val) {
							A[cur] = A[j];
							cur = j;
						} else {
							break;
						}
					}
				}
				A[cur] = val;
			} else {
				for (int j = i - 1; j >= 0; j--) {
					if ((A[j] & 1) == 0) {
						if (A[j] < val) {
							A[cur] = A[j];
							cur = j;
						} else {
							break;
						}
					}
				}
				A[cur] = val;
			}
		}
	}
}
