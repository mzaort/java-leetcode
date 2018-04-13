package solution;

public class StrStr {
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (haystack == null || needle == null) return null;
		int index = haystack.indexOf(needle);
		if (index == -1) {
			return null;
		} else {
			return haystack.substring(index);
		}
	}

	public String strStr2(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (haystack == null || needle == null) return null;

		int len1 = haystack.length();
		int len2 = needle.length();
		
		for (int index = 0; index <= len1 - len2; index++) {
			int j = index, k = 0;
			for(; k < len2 && haystack.charAt(j) == needle.charAt(k); k++, j++);
			if(k == len2) return haystack.substring(index);
		}
		return null;
	}
}
