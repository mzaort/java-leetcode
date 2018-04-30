package googleCode;

public class SqrtX {

	public static void main(String[] args) {
		SqrtX sx = new SqrtX();
		System.out.println(sx.sqrt(Integer.MAX_VALUE));
	}

	public int sqrt(int x) {
		assert (x >= 0);
		int left = 0, right = x;
		while (left <= right) {
			int mid = left + ((right - left) >>> 1);
			long val = ((long) mid) * mid;
			if (val == x) return mid;
			else if (val > x) right = mid - 1;
			else left = mid + 1;
		}
		return right;
	}

}
