package solution;

public class ValidNumber {
	//wrong
    public boolean isNumber(String s) {
    	//return s.trim().matches("^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)(e[+-]?\\d+)?$");
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(s == null || s.length() == 0) return false;
        int index = s.indexOf('e');
        if(index == -1){
        	int i = 0;
        	for(; i < s.length() && s.charAt(i) == ' '; i++);
        	if(i == s.length()){
        		return false;
        	}
        	
        	for(; i < s.length(); i++){
        		char ch = s.charAt(i);
        		if(ch == ' '){
        			break;
        		}else if(ch >= '0' && ch <= '9'){
        			continue;
        		}else{
        			return false;
        		}
        	}
        	for(; i < s.length(); i++){
        		if(s.charAt(i) != ' '){
        			return false;
        		}
        	}
        	return true;
        }else{
        	int i = index - 1;
        	for(; i >= 0; i--){
        		char ch = s.charAt(i);
        		if(ch == ' '){
        			break;
        		}else if(ch >= '0' && ch <= '9'){
        			continue;
        		}else{
        			return false;
        		}
        	}
        	for(; i >= 0; i--){
        		if(s.charAt(i) != ' '){
        			return false;
        		}
        	}
        	
        	i = index + 1;
        	for(; i < s.length(); i++){
        		char ch = s.charAt(i);
        		if(ch == ' '){
        			break;
        		}else if(ch >= '0' && ch <= '9'){
        			continue;
        		}else{
        			return false;
        		}
        	}
        	for(; i < s.length(); i++){
        		if(s.charAt(i) != ' '){
        			return false;
        		}
        	}
        	return true;
        }
    }
}
