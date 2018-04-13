package googleCode;

public class DecodeWays {
    public int numDecodings(String s) {
        int slen = s.length();
        if(slen == 0) return 1;
        
        int[] f = new int[slen + 1];
        f[slen] = 1;
        f[slen - 1] = s.charAt(slen - 1) == '0' ? 0 : 1; 
        for(int i = slen - 2; i >= 0; i--){
        	char sch = s.charAt(i);
        	if(sch >= '3'){
        		f[i] = f[i + 1];
        	}else if(sch == '2'){
        		if(s.charAt(i + 1) <= '6') f[i] = f[i + 1] + f[i + 2];
        		else f[i] = f[i + 1];
        	}else if(sch == '1'){
        		f[i] = f[i + 1] + f[i + 2];
        	}else{
        		f[i] = 0;
        	}
        }
        return f[0];
    }
    
    public int numDecodings2(String s){
    	int L = s.length();
    	int[] f = new int[L + 2];
    	f[L + 1] = 0;
    	f[L] = 1;
    	for(int i = L - 1; i >= 0; i--){
    		switch(s.charAt(i)){
    		case '0': f[i] = 0; break;
    		case '1': f[i] = f[i + 1] + f[i + 2]; break;
    		case '2': f[i] = i + 1 < L && s.charAt(i + 1) <= '6' ? f[i + 1] + f[i + 2] : f[i + 1]; break;
    		default: f[i] = f[i + 1]; break;
    		}
    	}
    	return f[0];
    }
    
}
