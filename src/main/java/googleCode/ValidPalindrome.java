package googleCode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
    	s = s.toLowerCase();
    	for(int i = 0, j = s.length() - 1; ; i++, j--){
    		for(; i < j && !(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))); i++);
    		for(; i < j && !(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j))); j--);
    		if(i >= j) return true;
    		if(s.charAt(i) != s.charAt(j)) return false;
    	}
    }
    public boolean isPalindrome2(String s) {
    	s = s.toLowerCase();
    	for(int i = 0, j = s.length() - 1; i < j; i++, j--){
    		for(; i < j && !(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))); i++);
    		for(; i < j && !(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j))); j--);
    		if(s.charAt(i) != s.charAt(j)) return false;
    	}
    	return true;
    }
}
