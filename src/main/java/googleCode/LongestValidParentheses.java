package googleCode;

import java.util.LinkedList;

public class LongestValidParentheses {
	
	public static void main(String[] args) {
		LongestValidParentheses lvp = new LongestValidParentheses();
		System.out.println(lvp.longestValidParentheses3(")()())"));
	}
	//when f[i] != -1 => f[f[i] - 1] = -1;
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        
        int res = 0;
        int[] f = new int[s.length()];
        f[0] = -1;
        for(int i = 1; i < s.length(); i++){
        	if(s.charAt(i) == '('){
        		f[i] = -1;
        	}else{
        		if(f[i - 1] == -1){
        			f[i] = s.charAt(i - 1) == '(' ? (i - 2 >= 0 && f[i - 2] != -1 ? f[i - 2] : i - 1) : -1;
        		}else{
        			int index = f[i - 1] - 1;
        			if(index >= 0 && s.charAt(index) == '('){
        				f[i] = (index - 1 >= 0 && f[index - 1] != -1) ? f[index - 1] : index;
        			}else{
        				f[i] = -1;
        			}
        		}
        	}
        }
        for(int i = 0; i < s.length(); i++){
        	if(f[i] != -1 && res < i - f[i] + 1) res = i - f[i] + 1;
        }
        return res;
    }
    
    public int longestValidParentheses2(String s) {
        if(s.length() < 2) return 0;
        
        int res = 0;
        int[] f = new int[s.length()];
        f[0] = -1;
        for(int i = 1; i < s.length(); i++){
        	if(s.charAt(i) == '('){
        		f[i] = -1;
        	}else{
        		if(s.charAt(i - 1) == '('){
        			f[i] = (i - 2 >= 0 && f[i - 2] != -1) ? f[i - 2] : i - 1;
        		}else{
        			if(f[i - 1] == -1){
        				f[i] = -1;
        			}else{
        				int index = f[i - 1] - 1;
        				if(index >= 0 && s.charAt(index) == '('){
        					f[i] = index - 1 >= 0 && f[index - 1] != -1 ? f[index - 1] : index;
        				}else{
        					f[i] = -1;
        				}
        			}
        		}
        	}
        }
        for(int i = 0; i < s.length(); i++){
        	if(f[i] != -1 && res < i - f[i] + 1) res = i - f[i] + 1;
        }
        return res;
    }
    public int longestValidParentheses3(String s){
    	int res = 0;
    	int last = -1;
    	LinkedList<Integer> indStack = new LinkedList<Integer>();
    	for(int i = 0; i < s.length(); i++){
    		if(s.charAt(i) == '('){
    			indStack.push(i);
    		}else{
    			if(indStack.isEmpty()){
    				last = i;
    			}else{
    				indStack.poll();
    				if(indStack.isEmpty()){
    					if(res < i - last) res = i - last;
    				}else{
    					if(res < i - indStack.peek()) res = i - indStack.peek();
    				}
    			}
    		}
    	}
    	return res;
    }
    
    public int longestValidParentheses4(String s){
    	int res = 0;
    	LinkedList<Integer> indStack = new LinkedList<Integer>();
    	LinkedList<Character> chStack = new LinkedList<Character>();
    	
    	for(int i = 0; i < s.length(); i++){
    		if(s.charAt(i) == '('){
    			indStack.push(i);
    			chStack.push('(');
    		}else{
    			Character top = chStack.peek();
    			if(top == null || top == ')'){
    				chStack.clear();
    				indStack.clear();
    				chStack.push(')');
    				indStack.push(i);
    			}else{
    				chStack.poll();
    				indStack.poll();
    				Integer frm = indStack.peek();
    				if(frm == null){
    					if(res < i + 1) res = i + 1;
    				}else{
    					if(res < i - frm) res = i - frm;
    				}
    			}
    		}
    	}
    	return res;
    }
}
