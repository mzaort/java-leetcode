package interview;

import java.util.Arrays;

public class SmallestLengthOfSubsequence{

	public static void main(String[] args) {
		SmallestLengthOfSubsequence slos = new SmallestLengthOfSubsequence();
		System.out.println(slos.smallestLength2("daaacassbcaa", "bcd"));
	}
	
	//no cycle;
	public int smallestLength(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 < len2) return -1;

		int[] f2 = new int[256];
		Arrays.fill(f2, 0);
		for(int i = 0; i < len2; i++) f2[s2.charAt(i)]++;

		int[] f1 = new int[256];
		Arrays.fill(f1, 0);

		int match = 0;
		int cur = 0;
		for(; cur < len1 && match < len2; cur++){
			int ch = s1.charAt(cur);
			f1[ch]++;
			if(f1[ch] <= f2[ch]) match++;
		}
		if(cur == len1 && match != len2) return -1;
		
		int left = 0;
		while(f1[s1.charAt(left)] > f2[s1.charAt(left)]){
			f1[s1.charAt(left)]--;
			left++;
		}
		
		int res = cur - left;
		for(; cur < len1; cur++){
			int ch = s1.charAt(cur);
			f1[ch]++;
			while(f1[s1.charAt(left)] > f2[s1.charAt(left)]){
				f1[s1.charAt(left)]--;
				left++;
			}
			if(res > cur - left + 1) res = cur - left + 1;
		}
		return res;
	}
	
	
	//cycle
	public int smallestLength2(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 < len2) return -1;

		int[] f2 = new int[256];
		Arrays.fill(f2, 0);
		for(int i = 0; i < len2; i++) f2[s2.charAt(i)]++;

		int[] f1 = new int[256];
		Arrays.fill(f1, 0);

		int match = 0;
		int cur = 0;
		for(; cur < len1 && match < len2; cur++){
			int ch = s1.charAt(cur);
			f1[ch]++;
			if(f1[ch] <= f2[ch]) match++;
		}
		if(cur == len1 && match != len2) return -1;
		
		int left = 0, right = cur - 1;
		while(f1[s1.charAt(left)] > f2[s1.charAt(left)]){
			f1[s1.charAt(left)]--;
			left++;
		}
		int res = cur - left;
		
		for(; cur < len1; cur++){
			int ch = s1.charAt(cur);
			f1[ch]++;
			while(f1[s1.charAt(left)] > f2[s1.charAt(left)]){
				f1[s1.charAt(left)]--;
				left++;
			}
			if(res > cur - left + 1) res = cur - left + 1;
		}

		for(cur = 0; cur < right; cur++){
			int ch = s1.charAt(cur);
			f1[ch]++;
			while(f1[s1.charAt(left)] > f2[s1.charAt(left)]){
				f1[s1.charAt(left)]--;
				left++;
			}
			if(cur + 1 != left){
				int tmp = (cur - left + 1 + len1) % len1;
				if(res > tmp) res = tmp;
			}			
		}
		return res;
	}
}