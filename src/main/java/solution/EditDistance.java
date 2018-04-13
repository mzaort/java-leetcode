package solution;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(word1.equals(word2)) return 0;
    	
        int len1 = word1.length(), len2 = word2.length();
        if(len1 == 0) return len2;
        if(len2 == 0) return len1;
        
        int[][] mat = new int[len1 + 1][len2 + 1];
        
        for(int i = 0; i <= len1; i++){
        	mat[i][0] = i;
        }
        for(int j = 0; j <= len2; j++){
        	mat[0][j] = j;
        }
        
        for(int i = 1; i <= len1; i++){
        	for(int j = 1; j <= len2; j++){
        		if(word1.charAt(i - 1) == word2.charAt(j - 1)){
        			mat[i][j] = mat[i - 1][j - 1];
        		}else{
        			int min = mat[i - 1][j - 1];
        			if(min > mat[i][j - 1]) min = mat[i][j - 1];
        			if(min > mat[i - 1][j]) min = mat[i - 1][j];
        			mat[i][j] = min + 1;
        		}
        	}
        }
        return mat[len1][len2];
    }
}
