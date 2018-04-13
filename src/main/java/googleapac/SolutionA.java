package googleapac;

import java.io.*;
import java.util.*;

public class SolutionA {
	public static void main(String[] args) throws FileNotFoundException{
		String infile = "E:\\Document\\A-large-practice.in";
		String outfile = "test.out";
		Scanner sin = new Scanner(new File(infile));
		PrintWriter pwr = new PrintWriter(new File(outfile));
		
		SolutionA st = new SolutionA();
		int t = Integer.parseInt(sin.nextLine());
		for(int k = 1; k <= t; k++){
			sin.nextInt();
			String[] series = sin.nextLine().trim().split("\\s");
			pwr.println("Case #" + k + ": " + st.next2(series));
		}
		
		sin.close();
		pwr.close();
	}

	public String next2(String[] series) {
		String res = error, str = null;
		boolean match = false;
		for (int i = 0; i < num; i++) {
			if ((str = next(series, i)) != null) {
				if(str.equals(error)) return error;
				if (!match) {
					match = true;
					res = str;
				} else {
					if (!res.equals(str)) {
						return error;
					}
				}
			}
		}
		return res;
	}
	
	private String next(String[] series, int cur) {
		int[] st = new int[bit];
		for(int k = 0; k < num && k < series.length; k++){
			for(int i = 0; i < bit; i++) if(series[k].charAt(i) == '1') st[i] = 1;
		}
		for(int i = series.length - 1, j = (cur + 1) % num, cnt = 0; cnt < num && i >= 0; i--, j = (j + 1) % num, cnt++){
			for(int k = 0; k < bit; k++){
				if(st[k] == 0){
					if(mask[j].charAt(k) == '1') st[k] = 2;
				}else if(st[k] == 1){
					if(mask[j].charAt(k) != series[i].charAt(k)) return null;
				}
			}
		}
		if(series.length >= num) return series[series.length - num];
		StringBuilder sb = new StringBuilder(mask[cur]);
		for(int i = 0; i < bit; i++){
			if(st[i] == 0){
				if(sb.charAt(i) == '1') return error;
			}else if(st[i] == 2){
				sb.setCharAt(i, '0');
			}
		}
		return new String(sb);
	}

	static String[] mask = {"1111110", "0110000", "1101101", "1111001", "0110011", "1011011", "1011111", "1110000","1111111", "1111011"};
	static String error = "ERROR!";
	static int num = 10;
	static int bit = 7;
	//google runtime;
	public String next(String[] series) {
		int len = series.length;
		Boolean[] flag = new Boolean[bit];
//		if(len >= num){
//			if(!isCycle(series)) return error;
//			for(int i = 0; i < num; i++){
//				if(isValid(series, flag, i)) return series[len - 10];
//			}
//			return error;
//		}else{
			int match = 0;
			String res = error;
			for(int i = 0; i < num; i++){
				if(isValid(series, flag, i)){
					String nextState = set(flag, mask[i]);
					if(nextState == null) return error;
					if(match == 0){
						match++;
						res = nextState;
					}else{
						if(!res.equals(nextState)) return error;
					}
				}
			}
			return res;
//		}
	}
	private String set(Boolean[] flag, String str) {
		StringBuilder sb = new StringBuilder(str);
		for(int i = 0; i < flag.length; i++){
			if(flag[i] == null){
				if(sb.charAt(i) == '1') return null;
			}else if(flag[i] == false){
				sb.setCharAt(i, '0');
			}
		}
		return new String(sb);
	}
	private boolean isValid(String[] series, Boolean[] flag, int val) {
		Arrays.fill(flag, null);
		for(int i = 0, cnt = 0; i < series.length && cnt < num; i++, cnt++){
			for(int j = 0; j < bit; j++) if(series[i].charAt(j) == '1') flag[j] = true;
		}
		for(int i = (val + 1) % num, j = series.length - 1, cnt = 0; cnt < num && j >= 0; i = (i + 1) % num, j--, cnt++){
			for(int k = 0; k < bit; k++){
				if(flag[k] == null){
					if(mask[i].charAt(k) == '1') flag[k] = false;
				}else if(flag[k] == true){
					if(mask[i].charAt(k) != series[j].charAt(k)) return false;
				}
			}
		}
		return true;
	}
	private boolean isCycle(String[] series) {
		for(int i = 0, j = num; j < series.length; i++, j++){
			if(series[i].equals(series[j])) return false;
		}
		return true;
	}
}
