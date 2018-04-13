package solution;

import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle == null || triangle.size() == 0) return 0;
        int len = triangle.size();
        int[] temp = new int[len];
        for(int i = 0; i < len; i++) temp[i] = 0;
        for(int i = len - 1; i >= 0; i--){
        	ArrayList<Integer> list = triangle.get(i);
        	for(int j = 0; j < i + 1; j++){
        		temp[j] += list.get(j);
        	}
        	for(int j = 0; j < i; j++){
        		if(temp[j] > temp[j + 1]){
        			temp[j] = temp[j + 1];
        		}
        	}
        }
        return temp[0];
    }
}
