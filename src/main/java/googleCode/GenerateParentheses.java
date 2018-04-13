package googleCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
    	assert(n >= 0);
    	List<String> res = new ArrayList<String>();
    	generateParenthesis(res, "", n, n);
    	return res;
    }

	private void generateParenthesis(List<String> res, String s, int m,
			int n) {
		if(m == 0){
			for(int i = 0; i < n; i++) s = s + ')';
			res.add(s);
		}else if(m == n){
			generateParenthesis(res, s + '(', m - 1, n);
		}else{
			generateParenthesis(res, s + '(', m - 1, n);
			generateParenthesis(res, s + ')', m, n - 1);
		}
	}
}
