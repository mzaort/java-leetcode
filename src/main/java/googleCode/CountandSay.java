package googleCode;

public class CountandSay {
    public String countAndSay(int n) {
    	assert(n >= 0);
    	String str = "1";
    	for(int i = 1; i < n; i++, str = next(str));
    	return str;
    }

	private String next(String str) {
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		char previous = str.charAt(0);
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == previous){
				cnt++;
			}else{
				sb.append(cnt).append(previous);
				cnt = 1;
				previous = str.charAt(i);
			}
		}
		sb.append(cnt).append(previous);
		return new String(sb);
	}
	
    public String countAndSay2(int n) {
    	assert(n >= 0);
    	String str = "1";
    	for(; n > 1; n--, str = next2(str));
    	return str;
    }
	
	private String next2(String str){
		StringBuilder sb = new StringBuilder();
		int cur = 0;
		while(cur < str.length()){
			int frm = cur;
			for(cur++; cur < str.length() && str.charAt(cur) != str.charAt(cur - 1); cur++);
			sb.append(cur - frm).append(str.charAt(frm));
		}
		return new String(sb);
	}
}
