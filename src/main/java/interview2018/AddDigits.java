package interview2018;

public class AddDigits {
	public int addDigits2(int num) {
		return (num - 1) % 9 + 1;
	}

	public int addDigits(int num) {
		while (num / 10 > 0) {
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			num = sum;
		}
		return num;
	}
}
