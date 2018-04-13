package interview2016;

import java.util.TreeSet;
import java.util.stream.Collectors;

public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		int i = 2, L = 100000;
		// for (; i < L && cp.isPrime(i) == cp.isPrime2(i); i++);
		// System.out.println(i == L);

		for (; i < L && cp.countPrimes2(i) == cp.countPrimes3(i); i++);
		System.out.println(i == L);
	}

	public int countPrimes(int n) {
		assert (n > 0);
		int res = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				res++;
			}
		}
		return res;
	}

	private boolean isPrime(int n) {
		assert (n >= 2);
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isPrime2(int n) {
		assert (n >= 2);
		for (int i = 2, L = (int) Math.sqrt(n); i <= L; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int countPrimes2(int n) {
		int res = 0;
		boolean[] f = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (!f[i]) {
				for (long j = i * i; j < n; j += i) {
					f[(int) (j)] = true;
				}
			}
		}
		for (int i = 2; i < n; i++) {
			if (!f[i]) {
				res++;
			}
		}
		return res;
	}

	public int countPrimes3(int n) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 2; i < n; i++) {
			set.add(i);
		}
		TreeSet<Integer> cset = new TreeSet<>(set);
		set.stream()
				.filter(cset::contains)
				.forEach(
						e -> {
							cset.removeAll(cset.tailSet(e).stream()
									.filter(t -> cset.contains(t * e))
									.collect(Collectors.toList()));
						});
		return set.size();
	}
}
