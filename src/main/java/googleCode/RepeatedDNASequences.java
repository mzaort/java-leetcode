package googleCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {

	// right [2, 3] is right;
	public List<String> findRepeatedDnaSequences6(String s) {
		List<String> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int hash = 0;
		for (int i = 0; i < 9 && i < s.length(); i++)
			hash = (hash << 2) + parse(s.charAt(i));
		for (int i = 0, j = 9; j < s.length(); i++, j++) {
			hash = ((hash & 0x3ffff) << 2) + parse(s.charAt(j));
			Integer val = map.get(hash);
			map.put(hash, val == null ? 1 : val + 1);
			if (map.get(hash) == 2) res.add(s.substring(i, j + 1));
		}
		return res;
	}

	private int parse(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			return -1;
		}
	}

	// wrong
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		Integer val = null;
		for (int i = 0, j = 10; j <= s.length(); i++, j++) {
			String st = s.substring(i, j);
			map.put(st, (val = map.get(st)) == null ? 1 : val + 1);
		}
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (e.getValue() > 1) res.add(e.getKey());
		}
		return res;
	}

	public List<String> findRepeatedDnaSequences2(String s) {
		List<String> res = new ArrayList<>();
		HashMap<String, List<Integer>> map = new HashMap<>();
		for (int i = 0, j = 10; j <= s.length(); i++, j++) {
			String st = s.substring(i, j);
			if (!map.containsKey(st)) map.put(st, new ArrayList<>());
			map.get(st).add(i);
		}
		for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
			List<Integer> lt = e.getValue();
			if (lt.size() > 1 && lt.get(lt.size() - 1) - lt.get(0) >= 10) res.add(e.getKey());
		}
		return res;
	}

	public List<String> findRepeatedDnaSequences3(String s) {
		HashMap<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (int i = 0, j = 10; j <= s.length(); i++, j++) {
			String st = s.substring(i, j);
			if (!map.containsKey(st)) map.put(st, i);
			else if (i - map.get(st) >= 10) set.add(st);
		}
		List<String> res = new ArrayList<>(set);
		return res;
	}

	public List<String> findRepeatedDnaSequences4(String s) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (int i = 0, j = 10; j <= s.length(); i++, j++) {
			String st = s.substring(i, j);
			int it = parse(st);
			if (!map.containsKey(it)) map.put(it, i);
			else if (i - map.get(it) >= 10) set.add(st);
		}
		List<String> res = new ArrayList<>(set);
		return res;
	}

	private int parse(String st) {
		int res = 0, val = 0;
		for (int i = 0; i < st.length(); i++) {
			switch (st.charAt(i)) {
			case 'A':
				val = 0;
				break;
			case 'C':
				val = 1;
				break;
			case 'G':
				val = 2;
				break;
			case 'T':
				val = 3;
				break;
			}
			res = (res << 2) + val;
		}
		return 0;
	}
}
