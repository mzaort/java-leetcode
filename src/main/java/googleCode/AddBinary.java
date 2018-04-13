package googleCode;

public class AddBinary {
    public String addBinary(String a, String b) {
    	StringBuilder sb = new StringBuilder();
    	int surplus = 0, shift = '0' + '0';
    	
    	int i = a.length() - 1, j = b.length() - 1;
    	for(; i >= 0 && j >= 0; i--, j--){
    		int tmp = a.charAt(i) + b.charAt(j) - shift + surplus;
    		sb.append(tmp % 2);
    		surplus = tmp / 2;
    	}
    	for(; i >= 0; i--){
    		int tmp = a.charAt(i) - '0' + surplus;
    		sb.append(tmp % 2);
    		surplus = tmp / 2;
    	}
    	
    	for(; j >= 0; j--){
    		int tmp = b.charAt(j) - '0' + surplus;
    		sb.append(tmp % 2);
    		surplus = tmp / 2;
    	}
    	
    	if(surplus != 0){
    		sb.append(surplus);
    	}
    	
    	return new String(sb.reverse());
    }
}
