package interview2015;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        class Pair{
        	int val;
        	int cur;
			public Pair(int val, int cur) {
				super();
				this.val = val;
				this.cur = cur;
			}
        }
        
        int[] res = {-1, -1};
        Pair[] p = new Pair[numbers.length];
        for(int i = 0; i < numbers.length; i++) p[i] = new Pair(numbers[i], i + 1);
        Arrays.sort(p, (o1, o2)->{return o1.val - o2.val;});
        for(int i = 0, j = p.length - 1; i < j; ){
        	int sum = p[i].val + p[j].val;
        	if(sum == target){
        		res[0] = Math.min(p[i].cur, p[j].cur);
        		res[1] = Math.max(p[i].cur, p[j].cur);
        		return res;
        	}else if(sum < target){
        		i++;
        	}else{
        		j--;
        	}
        }
        return res;
    }
    
    public int[] twoSum2(int[] numbers, int target) {
    	int[] res = {-1, -1};
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < numbers.length; i++){
    		Integer j = map.get(target - numbers[i]);
    		if(j == null){
    			map.put(numbers[i], i);
    		}else{
    			res[0] = j + 1;
    			res[1] = i + 1;
    			return res;
    		}
    	}
    	return res;
    }
}
