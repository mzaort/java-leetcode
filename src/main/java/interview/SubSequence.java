package interview;

import java.util.Arrays;

public class SubSequence{
	
	public static void main(String[] args) {
		SubSequence ss = new SubSequence();
		System.out.println(ss.isSubSequence("ab", "aaab"));
	}
	
	//O(m + n) O(1)
	public boolean isSubSequence(String s1, String s2){
		if(s2 == null) return true;
		if(s1 == null) return false;

		int len1 = s1.length();
		int len2 = s2.length();

		boolean[] flag = new boolean[256];
		for(int i = 0; i < 256; i++){
			flag[i] = false;
		}

		for(int i = 0; i < len1; i++){
			flag[s1.charAt(i)] = true;
		}
		
		int cur = 0;
		for(; cur < len2 && flag[s2.charAt(cur)]; cur++);
		return cur == len2;
	}
	
	public boolean isSubSequence2(String s1, String s2){
		if(s2 == null) return true;
		if(s1 == null) return false;

		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 < len2) return false;

		int[] flag = new int[256];
		for(int i = 0; i < 256; i++){
			flag[i] = 0;
		}
		
		for(int i = 0; i < len2; i++){
			flag[s2.charAt(i)]++;
		}
		
		int match = 0;
		for(int i = 0; i < len1; i++){
			int ch = s1.charAt(i);
			if(flag[ch] > 0){
				flag[ch]--;
				match++;
				if(match == len2){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isSubSequence3(String s1, String s2){
		if(s2 == null) return true;
		if(s1 == null) return false;

		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 < len2) return false;

		int[] f1 = new int[256];
		int[] f2 = new int[256];
		Arrays.fill(f1, 0);
		Arrays.fill(f2, 0);
		
		for(int i = 0; i < len1; i++) f1[s1.charAt(i)]++;
		for(int i = 0; i < len2; i++) f2[s2.charAt(i)]++;
		
		for(int i = 0; i < len2; i++){
			if(f1[s2.charAt(i)] < f2[s2.charAt(i)]){
				return false;
			}
		}		
		return true;
	}
	
}