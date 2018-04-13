package solution;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int slen = S.length();
    	int tlen = T.length();
    	if(tlen == 0 || tlen > slen) return "";
    	
    	int[] loc = new int[slen];
    	for(int i = 0; i < slen; i++){
    		loc[i] = -1;
    	}
    	
    	for(int i = 0; i < tlen; i++){
    		char tmp = T.charAt(i);
    		int index = S.indexOf(tmp);
    		if(index == -1) return "";
    		while(index != -1){
    			loc[index] = i;
    			index = S.indexOf(tmp, index + 1);
    		}
    	}
    	
    	return "";
    }
}
