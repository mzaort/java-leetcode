package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadPhoneNumber {
	public static final String[] digits = {"zero", "one", "two", "three", "four",
		"five", "six", "seven", "eight", "nine"};
	public static final String[] cnts = {"", "", "double", "triple", "quadruple",
		"quintuple", "sextuple", "septuple", "octuple", "nonuple", "decuple"};
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sin = new Scanner(new File("A-large-practice.in"));
		PrintWriter pwr = new PrintWriter(new File("A-large-practice.out"));
		ReadPhoneNumber rpn = new ReadPhoneNumber();
		
		int cnt = sin.nextInt();
		sin.nextLine();
		for(int k = 1; k <= cnt; k++){
			String line = sin.nextLine();
			String[] strs = line.split(" ");
			String[] nums = strs[1].split("-");
			int[] num = new int[nums.length];
			for(int i = 0; i < nums.length; i++) num[i] = Integer.parseInt(nums[i]);
			pwr.println("Case #" + k + ": " + rpn.parse(strs[0], num));
		}
		sin.close();
		pwr.close();
	}

	private String parse(String s, int[] num) {
		StringBuilder sb = new StringBuilder();
		int nlen = num.length;
		for(int i = 1; i < nlen; i++) num[i] = num[i] + num[i - 1];
		for(int i = 0; i < nlen; i++){
			int cur = i == 0 ? 0 : num[i - 1];
			while(cur < num[i]){
				int frm = cur;
				char ch = s.charAt(cur);
				for(cur++; cur < num[i] && s.charAt(cur) == ch; cur++);
				int cnt = cur - frm;
				if(cnt == 1){					
					sb.append(digits[ch - '0'] + " ");				
				}else if(cnt <= 10){
					sb.append(cnts[cnt] + " " + digits[ch - '0'] + " ");
				}else{
					for(int k = 0; k < cnt; k++) sb.append(digits[ch - '0'] + " ");
				}
			}
		}
		return s.length() == 0 ? "" : new String(sb.substring(0, sb.length() - 1));
	}	
}
