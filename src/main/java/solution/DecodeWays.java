package solution;

public class DecodeWays {

	public static void main(String[] args) {

	}

	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		if (len == 0 || s.charAt(0) == '0') return 0;

		int[] res = new int[len + 1];
		res[0] = 1;// attention...为什么不是0？
		res[1] = 1;

		for (int i = 2; i <= len; i++) {
			int i1 = s.charAt(i - 1) - '0';
			int i2 = s.charAt(i - 2) - '0';
			if(i1 < 0 || i1 > 9 || i2 < 0 || i2 > 9) return 0;
			switch(i2){
			case 0:
				if(i1 == 0){
					return 0;
				}else{
					res[i] = res[i - 1];
				}
				break;
			case 1:
				if(i1 == 0){
					res[i] = res[i - 2];
				}else{
					res[i] = res[i - 1] + res[i - 2];
				}
				break;
			case 2:
				if(i1 == 0){
					res[i] = res[i - 2];
				}else if(i1 <= 6){
					res[i] = res[i - 1] + res[i - 2];
				}else{
					res[i] = res[i - 1];
				}
				break;
			default:
				if(i1 == 0){
					return 0;
				}else{
					res[i] = res[i - 1];
				}
			}
		}

		return res[len];
	}

}
