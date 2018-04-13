package googleCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		System.out.println(sm.spiralOrder(new int[][]{
				{1, 2, 3},{4, 5, 6},{7, 8, 9}}));
	}
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length != 0 && matrix[0].length != 0){
        	int[] num = {matrix[0].length, matrix.length - 1};
        	int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        	int dir = 0;
        	int x = 0, y = -1;
        	while(true){
        		int flag = dir & 1;
        		for(int i = 0; i < num[flag]; i++){
        			x += direction[dir][0];
        			y += direction[dir][1];
        			res.add(matrix[x][y]);
        		}
        		num[flag]--;
        		dir = (dir + 1) % 4;
        		if(num[1 - flag] == 0) break;
        	}
        }
        return res;
    }
}
