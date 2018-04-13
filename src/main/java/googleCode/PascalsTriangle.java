package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
    	assert(numRows >= 0);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(numRows > 0){
    		res.add(new ArrayList<Integer>(Arrays.asList(1)));
    		for(int i = 1; i < numRows; i++){
    			List<Integer> prev = res.get(i - 1);
    			List<Integer> tmp = new ArrayList<Integer>();
    			tmp.add(1);
    			for(int j = 1; j < prev.size(); j++){
    				tmp.add(prev.get(j - 1) + prev.get(j));
    			}
    			tmp.add(1);
    			res.add(tmp);
    		}
    	}    	
    	return res;
    }
}
