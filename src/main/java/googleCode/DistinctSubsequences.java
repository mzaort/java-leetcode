package googleCode;

public class DistinctSubsequences {
	public static void main(String[] args) {
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinct("", "a"));
	}
	
	public int numDistinct(String S, String T) {
		int slen = S.length(), tlen = T.length();
		int[][] mat = new int[slen + 1][tlen + 1];
		for (int j = 1; j <= tlen; j++)	mat[0][j] = 0;
		for (int i = 0; i <= slen; i++)	mat[i][0] = 1;
		for (int i = 1; i <= slen; i++) {
			for (int j = 1; j <= tlen; j++) {
				mat[i][j] = S.charAt(i - 1) == T.charAt(j - 1) ? mat[i - 1][j - 1]
						+ mat[i - 1][j]
						: mat[i - 1][j];
			}
		}
		return mat[slen][tlen];
	}
	
	public int numDistinct2(String S, String T){
		return f(new Integer[S.length() + 1][T.length() + 1], S.length(), T.length(), S, T);
	}

	private int f(Integer[][] v, int i, int j, String s,
			String t) {
		if(v[i][j] == null){
			if(i < j){
				v[i][j] = 0;
			}else if(j == 0){
				v[i][j] = 1;
			}else{
				char sch = s.charAt(i - 1), tch = t.charAt(j - 1);
				v[i][j] = (sch == tch) ? v[i - 1][j - 1] + v[i - 1][j] : v[i - 1][j];
			}
		}
		return v[i][j];
	}
}
