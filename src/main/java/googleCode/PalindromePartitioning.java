package googleCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
	
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition3("a"));
	}
    public List<List<String>> partition(String s) {
        return partition(s, 0);
    }

	private List<List<String>> partition(String s, int i) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(i == s.length()){
			res.add(new ArrayList<String>());
		}else{
			for(int j = i; j < s.length(); j++){
				if(isPalindrome(s, i, j)){
					String str = s.substring(i, j + 1);
					for(List<String> e : partition(s, j + 1)){
						List<String> list = new ArrayList<String>();
						list.add(str);
						list.addAll(e);
						res.add(list);
					}
				}
			}
		}
		return res;
	}
	
	private boolean isPalindrome(String s, int i, int j) {
		for (; i <= j && s.charAt(i) == s.charAt(j); i++, j--);
		return i > j;
	}
	
	public List<List<String>> partition2(String s) {
        return partition(s, 0, new HashMap<Integer, List<List<String>>>());
    }

	private List<List<String>> partition(String s, int i,
			Map<Integer, List<List<String>>> map) {
		if(!map.containsKey(i)){
			List<List<String>> res = new ArrayList<List<String>>();
			if(i == s.length()){
				res.add(new ArrayList<String>());
			}else{
				for(int j = i; j < s.length(); j++){
					if(isPalindrome(s, i, j)){
						String str = s.substring(i, j + 1);
						for(List<String> e : partition(s, j + 1)){
							List<String> list = new ArrayList<String>();
							list.add(str);
							list.addAll(e);
							res.add(list);
						}
					}
				}
			}
			map.put(i, res);
		}
		return map.get(i);
	}
	
	public List<List<String>> partition3(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(res, new ArrayList<String>(), s, 0);
		return res;
    }
	
	public List<List<String>> partition4(String s) {
		int len = s.length();
		List<List<List<String>>> res = new ArrayList<List<List<String>>>(len + 1);
		List<List<String>> list = new ArrayList<List<String>>();
		list.add(new ArrayList<String>());
		res.add(list);
		for(int i = 1; i <= len; i++){
			list = new ArrayList<List<String>>();
			for(int j = 0; j < i; j++){
				if(isPalindrome(s, j, i - 1)){
					String str = s.substring(j, i);
					for(List<String> e : res.get(j)){
						List<String> tmp = new ArrayList<String>(e);
						tmp.add(str);
						list.add(tmp);
					}
				}
			}
			res.add(list);
		}
		return res.get(len);
    }

	private void dfs(List<List<String>> res, ArrayList<String> list,
			String s, int i) {
		if(i == s.length()){
			res.add(new ArrayList<String>(list));
		}else{
			for(int j = i; j < s.length(); j++){
				if(isPalindrome(s, i, j)){
					list.add(s.substring(i, j + 1));
					dfs(res, list, s, j + 1);
					list.remove(list.size() - 1);
				}
			}
		}
	}
}
