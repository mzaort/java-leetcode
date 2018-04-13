package googleCode;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	int oprand1, oprand2;
    	for(String s : tokens){
    		if(s.length() == 1){
    			char ch = s.charAt(0);
    			switch(ch){
        		case '+':
        			oprand2 = stack.poll();
        			oprand1 = stack.poll();
        			stack.push(oprand1 + oprand2);
        			break;
        		case '-':
        			oprand2 = stack.poll();
        			oprand1 = stack.poll();
        			stack.push(oprand1 - oprand2);
        			break;
        		case '*':
        			oprand2 = stack.poll();
        			oprand1 = stack.poll();
        			stack.push(oprand1 * oprand2);
        			break;
        		case '/':
        			oprand2 = stack.poll();
        			oprand1 = stack.poll();
        			stack.push(oprand1 / oprand2);
        			break;
        		default:
        			stack.push(Integer.parseInt(s));
        			break;
        		}
    		}else{
    			stack.push(Integer.parseInt(s));
    		}
    		
    	}
    	return stack.poll();
    }
    
    public int evalRPN2(String[] tokens){
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	for(String s : tokens){
    		if(isOperator(s)){
    			int op2 = stack.poll();
    			int op1 = stack.poll();
    			switch(s.charAt(0)){
    			case '+' : stack.push(op1 + op2); break;
    			case '-' : stack.push(op1 - op2); break;
    			case '*' : stack.push(op1 * op2); break;
    			case '/' : stack.push(op1 / op2); break;
    			}
    		}else{
    			stack.push(Integer.parseInt(s));
    		}
    	}
    	return stack.poll();
    }

	private boolean isOperator(String s) {
		return s.length() == 1 && !Character.isDigit(s.charAt(0));
	}
}
