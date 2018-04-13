package solution;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters lswd = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(lswd.lengthOfLongestSubstring("a"));
	}
	
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	int res = 1;
    	
    	char[] cstr = s.toCharArray();
    	for(int i = 0; i < cstr.length - res; i++){
    		for(int j = i + 1; j < cstr.length; j++){
    			boolean flag = true;
    			for(int k = i; k < j; k++){
    				if(cstr[k] == cstr[j]){
    					flag = false;
    					break;
    				}
    			}
    			if(flag == false){
    				if(j - i > res){
    					res = j - i;
    				}
    				break;
    			}else{
    				if(j - i + 1 > res){
    					res = j - i + 1;
    				}
    			}
    		}
    	}
    	
    	return res;
    }
}
