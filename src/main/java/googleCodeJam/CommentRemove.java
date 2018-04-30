package googleCodeJam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CommentRemove {
	public static void main(String[] args) throws IOException {
		Scanner sin = new Scanner(new File("E-large-practice.in"));
		PrintWriter pwr = new PrintWriter(new File("E-large-practice.out"));
		pwr.println("Case #1:");
		int cnt = 0;
		while (sin.hasNextLine()) {
			String line = sin.nextLine();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				if (ch == '/') {
					if (i + 1 < line.length() && line.charAt(i + 1) == '*') {
						cnt++;
						i++;
					} else {
						if (cnt == 0) sb.append(ch);
					}
				} else if (ch == '*') {
					if (cnt > 0 && i + 1 < line.length() && line.charAt(i + 1) == '/') {
						cnt--;
						i++;
					} else {
						if (cnt == 0) sb.append(ch);
					}
				} else {
					if (cnt == 0) sb.append(ch);
				}
			}
			if (cnt == 0) sb.append('\n');
			pwr.print(sb.toString());
		}
		sin.close();
		pwr.close();
	}
}
