package googleCode;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
    	int cur = s.length() - 1;
    	for(; cur >= 0 && s.charAt(cur) == ' '; cur--);
    	int end = cur;
    	for(; cur >= 0 && s.charAt(cur) != ' '; cur--);
    	return end - cur;
    }
}
