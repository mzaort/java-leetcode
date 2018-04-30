package googleCode;

public class JumpGame {

	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		System.out.println(jg.canJump(new int[] { 0 }));
	}

	public boolean canJump(int[] A) {
		int limit = 0;
		for (int i = 0; i <= limit && limit < A.length - 1; i++) {
			limit = Math.max(limit, i + A[i]);
		}
		return limit >= A.length - 1;
	}
}
