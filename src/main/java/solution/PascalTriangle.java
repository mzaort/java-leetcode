package solution;

import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		assert(numRows >= 1);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		res.add(list);
		
		for(int i = 2; i <= numRows; i++){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			Integer[] from = list.toArray(new Integer[0]);
			for(int j = 0; j < from.length - 1; j++){
				tmp.add(from[j] + from[j+1]);
			}
			tmp.add(1);
			res.add(tmp);
			list = tmp;
		}

		return res;
	}
}
