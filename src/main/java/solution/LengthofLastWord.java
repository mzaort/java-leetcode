package solution;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return 0;
        int ind1, ind2;
        for(ind1 = s.length() - 1; ind1 >= 0; ind1--){
        	char c = s.charAt(ind1);
        	if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
        		break;
        	}
        }
        if(ind1 == -1) return 0;
        for(ind2 = ind1; ind2 >= 0; ind2--){
        	char c = s.charAt(ind2);
        	if(c == ' '){
        		break;
        	}
        }
        return ind1 - ind2;
    }
}
