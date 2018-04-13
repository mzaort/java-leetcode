package googleCode;

import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
    	LinkedList<Character> stack = new LinkedList<Character>();
    	for(int i = 0; i < s.length(); i++){
    		char ch = s.charAt(i);
    		if(ch == '[' || ch == '(' || ch == '{'){
    			stack.push(ch);
    		}else{
    			if(stack.isEmpty()) return false;
    			if(stack.poll() - ch > 2) return false;
    		}
    	}    	
    	return stack.isEmpty();
    }
    
    public boolean isValid2(String s) {
    	char[] stack = s.toCharArray();
    	int top = 0;
    	for(int i = 0; i < stack.length; i++){
    		char ch = s.charAt(i);
    		if(ch == '[' || ch == '(' || ch == '{'){
    			stack[top++] = ch;
    		}else{
    			if(top == 0) return false;
    			if(stack[--top] - ch > 2) return false;
    		}
    	}    	
    	return top == 0;
    }
}
