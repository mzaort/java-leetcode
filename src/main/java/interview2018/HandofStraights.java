package interview2018;

import java.util.Arrays;

public class HandofStraights {
	public boolean isNStraightHand(int[] hand, int W) {
		if (W <= 1 || hand.length == 0) return true;
		if (hand.length % W != 0) return false;
		Arrays.sort(hand);
		for (int i = 0; i <= hand.length - W; i = next(hand, i + 1)) {
			if (!isStrait(hand, i, W)) return false;
		}
		return true;
	}

	private int next(int[] hand, int i) {
		for (; i < hand.length && hand[i] == Integer.MIN_VALUE; i++);
		return i;
	}

	private int next(int[] hand, int i, int v) {
		for (; i < hand.length && hand[i] != v; i++);
		return i;
	}

	private boolean isStrait(int[] hand, int frm, int W) {
		int j = 0;
		for (int i = frm, v = hand[frm]; j < W && i < hand.length; j++, v++, i = next(hand, i + 1, v)) {
			hand[i] = Integer.MIN_VALUE;
		}
		return j == W;
	}

	public static void main(String[] args) {
		int[] h = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		System.out.println(new HandofStraights().isNStraightHand(h, 3));
	}
}
