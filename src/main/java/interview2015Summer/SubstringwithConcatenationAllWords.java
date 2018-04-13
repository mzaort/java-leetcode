package interview2015Summer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationAllWords {

	public List<Integer> findSubstring(String S, String[] L){
		assert(L.length != 0 && L[0].length() != 0);
		List<Integer> res = new ArrayList<>();
		
		int step = L[0].length(), llen = step * L.length;
		Integer val = null;
		Map<String, Integer> expected = new HashMap<String, Integer>();
		for(String s : L) expected.put(s, (val = expected.get(s)) == null ? 1 : val + 1);
		String[] sif = new String[S.length()];
		for(int i = 0; i <= S.length() - step; i++){
			String s = S.substring(i, i + step);
			if(expected.containsKey(s)) sif[i] = s;
		}
		for(int i = 0; i <= S.length() - llen; i++){
			int j = i;
			Map<String, Integer> real = new HashMap<>();
			for(; j < i + llen && sif[j] != null; j += step){
				real.put(sif[j], (val = real.get(sif[j])) == null ? -1 : val + 1);
				if(real.get(sif[j]) > expected.get(sif[j])) break;
			}
			if(j == i + llen) res.add(i);
		}
		return res;
	}
	
}
