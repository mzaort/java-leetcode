package googleCode;

public class GasStation {
	public static void main(String[] args) {
		int[] gas = { 4 };
		int[] cost = { 5 };
		GasStation gs = new GasStation();
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		assert (gas.length == cost.length);
		int index = canCompleteCircuitClockWise(gas, cost);
		if (index != -1) return index;
		for (int i = 0, j = gas.length - 1; i < j; i++, j--) {
			int tmp = gas[i];
			gas[i] = gas[j];
			gas[j] = tmp;
		}
		for (int i = 0, j = cost.length - 2; i < j; i++, j--) {
			int tmp = cost[i];
			cost[i] = cost[j];
			cost[j] = tmp;
		}
		index = canCompleteCircuitClockWise(gas, cost);
		return index == -1 ? -1 : gas.length - 1 - index;
	}

	private int canCompleteCircuitClockWise(int[] gas, int[] cost) {
		int[] gasSum = new int[gas.length];
		gasSum[0] = gas[0];
		for (int i = 1; i < gas.length; i++)
			gasSum[i] = gasSum[i - 1] + gas[i];

		int[] costSum = new int[cost.length];
		costSum[0] = cost[0];
		for (int i = 1; i < costSum.length; i++)
			costSum[i] = costSum[i - 1] + cost[i];

		for (int i = 0; i < gas.length; i++) {
			int cur = i;
			int diff = i == 0 ? 0 : gasSum[i - 1] - costSum[i - 1];
			int ndiff = gasSum[gas.length - 1] - costSum[gas.length - 1];
			for (; cur < gas.length && (gasSum[cur] - costSum[cur] - diff >= 0); cur++);
			if (cur < gas.length) continue;
			for (cur = 0; cur <= i && (ndiff - diff + gasSum[cur] - costSum[cur]) >= 0; cur++);
			if (cur <= i) continue;
			return i;
		}
		return -1;
	}

	public int canCompleteCircuit3(int[] gas, int[] cost) {
		int N = gas.length;
		for (int i = 0, g = 0, j = 0, index = 0; j < N * 2; j++, i = (i + 1) % N) {
			if (g + gas[i] >= cost[i]) {
				g = g + gas[i] - cost[i];
				if ((i + 1) % N == index) return index;
			} else {
				g = 0;
				index = (i + 1) % N;
			}
		}
		return -1;
	}

	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int j = -1;
		int total = 0;
		for (int i = 0, sum = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				j = i;
				sum = 0;
			}
		}
		return total >= 0 ? j + 1 : -1;
	}
}
