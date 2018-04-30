package microsoft;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		FirstUniqueCharacter fuc = new FirstUniqueCharacter();
		System.out.println(fuc.firstUnique("abcabcd"));
	}

	public char firstUnique(String str) {
		int len = str.length();
		assert (len > 0);

		int[] cnt = new int[256];
		for (int i = 0; i < 256; i++) {
			cnt[i] = 0;
		}

		for (int i = 0; i < len; i++) {
			cnt[str.charAt(i)]++;
		}

		for (int i = 0; i < len; i++) {
			if (cnt[str.charAt(i)] == 1) { return str.charAt(i); }
		}

		return '\0';
	}
}