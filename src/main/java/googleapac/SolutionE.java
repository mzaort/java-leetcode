package googleapac;

import java.io.*;
import java.util.*;

public class SolutionE {
	public static void main(String[] args) throws FileNotFoundException {
		String[] infile = { "test.in", "E-small.in", "E-large.in" };
		String[] outfile = { "test.out", "E-small.out", "E-large.out" };
		Scanner sin = new Scanner(new File(infile[0]));
		PrintWriter pwr = new PrintWriter(new File(outfile[0]));

		SolutionE st = new SolutionE();
		int t = Integer.parseInt(sin.nextLine());
		for (int k = 1; k <= t; k++) {

			pwr.println("Case #" + k + ": ");
		}

		sin.close();
		pwr.close();
	}
}
