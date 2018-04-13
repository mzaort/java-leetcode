package solution;

public class MultiplyStrings {
	
	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
	}
	
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = num1.length(), len2 = num2.length();
        if(len1 == 0 || len2 == 0) return "";
        
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();
        
        StringBuilder[] sb = new StringBuilder[len2];
        for(int i = 0; i < len2; i++){
        	sb[i] = multiply(sb1, sb2.charAt(i));
        }
        
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        int surplus = 0, cur = 0;
        
        while(flag){
        	int tmp = surplus;
        	flag = false;
        	for(int i = 0; i < len2; i++){
        		if(sb[i].length() > cur){
        			tmp += sb[i].charAt(cur);
        			flag = true;
        		}
        	}
        	if(flag == false && tmp != 0){
        		res.append((char) (tmp + '0'));
        	}else{
        		res.append((char)((tmp % 10) + '0'));
            	surplus = tmp / 10;
        	}
        }
        
        return new String(res.reverse());
    }

	private StringBuilder multiply(StringBuilder sb1, char ch) {
		StringBuilder res = new StringBuilder();
		int surplus = 0;
		int len = sb1.length();
		for(int i = 0; i < len; i++){
			int tmp = (sb1.charAt(i) - '0') * (ch - '0') + surplus;
			res.append((char)(tmp % 10));
			surplus = tmp/10;
		}
		if(surplus != 0){
			res.append((char)surplus);
		}
		return res;
	}

}
