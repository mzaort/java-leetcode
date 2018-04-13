package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
	
	public static void main(String[] args) {
		WordLadderII wl = new WordLadderII();
		Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
		System.out.println(wl.findLadders("hit", "cog", dict));
	}
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	LinkedList<String> queue = new LinkedList<String>();
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	Map<String, Integer> maplen = new HashMap<String, Integer>();
    	queue.add(start);
    	maplen.put(start, 1);
    	
    	String front = null;
    	while((front = queue.poll()) != null){
    		if(front.equals(end)){
    			findPath(res, new ArrayList<String>(), start, end, map);
    			for(List<String> e : res) Collections.reverse(e);
    		}
    		int distance = maplen.get(front);
    		char[] chs = front.toCharArray();
    		for(int i = 0; i < chs.length; i++){
    			char ch = chs[i];
    			for(char c = 'a'; c < 'z'; c++){
    				if(c != ch){
    					chs[i] = c;
    					String str = new String(chs);
    					if(str.equals(end) || dict.contains(str)){
    						if(maplen.containsKey(str)){
    							if(maplen.get(str) == distance + 1){
    								map.get(str).add(front);
    							}
    						}else{
    							queue.add(str);
    							maplen.put(str, distance + 1);
    							map.put(str, new ArrayList<String>(Arrays.asList(front)));
    						}
    					}
    				}
    			}
    			chs[i] = ch;
    		}
    	}
    	return res;
    }

	private void findPath(List<List<String>> res, List<String> list,
			String start, String end, Map<String, List<String>> map) {
		if(end.equals(start)){
			list.add(start);
			res.add(new ArrayList<String>(list));
			list.remove(list.size() - 1);
		}else{
			list.add(end);
			for(String e : map.get(end)){
				findPath(res, list, start, e, map);
			}
			list.remove(list.size() - 1);
		}
	}
	
//	private void findPath2(List<List<String>> res, List<String> list,
//			String start, String end, Map<String, List<String>> map) {
//		if(end.equals(start)){
//			list.add(end);
//			res.add(list);
//		}else{
//			for(String e : map.get(end)){
//				List<String> tmp = new ArrayList<String>(list);
//				tmp.add(end);
//				findPath(res, tmp, start, e, map);
//			}
//		}
//	}
}
