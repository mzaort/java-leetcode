package googleCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
    	assert(L.length != 0 && L[0].length() != 0);
        List<Integer> res = new ArrayList<Integer>();
        int slen = S.length(), alen = L.length * L[0].length();
        Map<String, Integer> maploc = new HashMap<String, Integer>();
        for(String e : L){
        	if(!maploc.containsKey(e)){
        		maploc.put(e, 1);
        	}else{
        		maploc.put(e, maploc.get(e) + 1);
        	}
        }
        
        for(int i = 0; i <= slen - alen; i++){
        	if(dfs(S, i, L[0].length(), new HashMap<String, Integer>(maploc))) res.add(i);
        }
        return res;
    }

	private boolean dfs(String s, int i, int len,
			Map<String, Integer> maploc) {
		if(maploc.size() == 0) return true;
		if(i + len > s.length()) return false;
		String str = s.substring(i, i + len);
		Integer val = maploc.get(str);
		if(val== null) return false;
		if(val == 1) maploc.remove(str);
		else maploc.put(str, val - 1);
		return dfs(s, i + len, len, maploc);
	}
	
	public List<Integer> findSubstring2(String S, String[] L) {
    	assert(L.length != 0 && L[0].length() != 0);
        List<Integer> res = new ArrayList<Integer>();
        int slen = S.length(), llen = L[0].length(), alen = L.length * L[0].length();
        Map<String, Integer> maploc = new HashMap<String, Integer>();
        Integer val = null;
        for(String e : L){
        	maploc.put(e, (val = maploc.get(e)) == null ? 1 : val + 1);
        }
        String[] sif = new String[slen];
        for(int i = 0; i <= slen - llen; i++){
        	String subs = S.substring(i, i + llen);
        	if(maploc.containsKey(subs)) sif[i] = subs;
        }
        
        for(int i = 0; i <= slen - alen; i++){
        	if(dfs(S, i, new HashMap<String, Integer>(maploc), sif)) res.add(i);
        }
        return res;
    }

	private boolean dfs(String s, int i, Map<String, Integer> map, String[] sif) {
		if(map.size() == 0) return true;
		if(sif[i] == null) return false;
		if(!map.containsKey(sif[i])) return false;
		int val = map.get(sif[i]);
		if(val == 1) map.remove(sif[i]);
		else map.put(sif[i], val - 1);
		return dfs(s, i + sif[i].length(), map, sif);
	}
	
	public List<Integer> findSubstring3(String S, String[] L) {
    	assert(L.length != 0 && L[0].length() != 0);
        List<Integer> res = new ArrayList<Integer>();
        
        Integer val = null;
        Map<String, Integer> expected = new HashMap<String, Integer>();
        for(String e : L)  expected.put(e, (val = expected.get(e)) == null ? 1 : val + 1);
        
        String[] sif = new String[S.length()];
        for(int i = 0, step = L[0].length(), limit = S.length() - step; i <= limit; i++){
        	String subs = S.substring(i, i + step);
        	if(expected.containsKey(subs)) sif[i] = subs;
        }
        
        for(int i = 0, alen = L.length * L[0].length(), step = L[0].length(), limit = S.length() - alen; i <= limit; i++){
        	int j = i;
        	Map<String, Integer> real = new HashMap<String, Integer>();
        	for(; j < i + alen && sif[j] != null; j += step){
        		real.put(sif[j], (val = real.get(sif[j])) == null ? 1 : val + 1);
        		if(real.get(sif[j]) > expected.get(sif[j])) break;
        	}
        	if(j == i + alen) res.add(i);
        }
        return res;
    }
}
