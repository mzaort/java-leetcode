package interview2018;

import java.util.HashMap;
import java.util.Map;

public class RabbitsinForest {
	public int numRabbits(int[] answers) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int e : answers) {
			count.put(e, count.getOrDefault(e, 0) + 1);
		}

		// Map<Integer, Integer> count = Arrays.stream(answers).collect(() ->
		// new HashMap<Integer, Integer>(),
		// (m, e) -> m.put(e, m.getOrDefault(e, 0) + 1), HashMap::putAll);
		int res = 0;
		for (Map.Entry<Integer, Integer> e : count.entrySet()) {
			int c = e.getKey() + 1;
			res += (e.getValue() / c + (e.getValue() % c == 0 ? 0 : 1)) * c;
		}
		return res;
	}
}
