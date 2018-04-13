package solutionReview;

import java.util.*;

public class PermutationII{
	public ArrayList<ArrayList<Integer>> permutateUnique(int[] num){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if(len == 0){
			res.add(new ArrayList<Integer>());
			return res;
		}
		
		Arrays.sort(num);
		while(true){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int e : num) list.add(e);
			res.add(list);
			
			int i = len - 2;
			for(; i >= 0 && num[i] >= num[i + 1]; i--);
			if(i >= 0){
				for(int j = i + 1, k = len -1; j < k; j++, k--) swap(num, j, k);
				swap(num, i, searchInsertionIndex(num, i + 1, len - 1, num[i]));
			}else{
				break;
			}
		}
		return res;
	}

	public int searchInsertionIndex(int[] arr, int i, int j, int target){
		while(i <= j){
			int mid = i + ((j - i) >> 1);
			if(arr[mid] <= target){
				i = mid + 1;
			}else{
				j = mid - 1;
			}
		}
		return i;
	}

	public int searchInsertionIndex2(int[] arr, int i, int j, int target){
		while(i <= j){
			int mid = i + ((j - i) >> 1);
			if(arr[mid] < target){
				i = mid + 1;
			}else{
				j = mid - 1;
			}
		}
		return j;
	}
	
	private void swap(int[] index, int dest, int src) {
		int tmp = index[dest];
		index[dest] = index[src];
		index[src] = tmp;
	}
}