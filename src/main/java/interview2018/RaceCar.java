package interview2018;

import java.util.HashMap;
import java.util.Map;

public class RaceCar {
	public int racecar(int target) {
		return racecar(new HashMap<Integer, Integer>(), target, 0, 1, 0);
	}

	private int racecar(Map<Integer, Integer> f, int T, int pos, int speed, int c) {
		if (!f.containsKey(T)) {
			int cnt = 0;
			if (pos == T) cnt = c;
			else if (pos < T) {
				if (speed > 0) {
					cnt = racecar(f, T, pos + speed, speed * 2, c + 1);
					if (pos + speed > T) {
						cnt = Math.min(cnt, racecar(f, T - pos, 0, 1, c + 2));
					}
				} else { // < 0
					cnt = racecar(f, T - pos, 0, 1, c + 1);
				}
			} else {
				if (speed > 0) {
					cnt = racecar(f, pos - T, 0, 1, c + 1);
				} else { // > 0
					cnt = racecar(f, T, pos + speed, speed * 2, c + 1);
					if (pos + speed < T) {
						cnt = Math.min(cnt, racecar(f, pos - T, 0, 1, c + 2));
					}
				}
			}
			f.put(T, cnt);
		}
		return f.get(T);
	}

	public static void main(String[] args) {
		RaceCar rc = new RaceCar();
		System.out.println(rc.racecar(5));
	}
}
