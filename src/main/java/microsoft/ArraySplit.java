package microsoft;

import java.util.*;

public class ArraySplit{
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 11, 12, 13};
		ArraySplit as = new ArraySplit();
		System.out.println(as.maxSplit(arr));
	}

	public int maxSplit(int[] arr){
		int len = arr.length;
		if(len <= 1) return len;
		
		int sum = 0;
		for(int e : arr) sum += e;
		boolean[] flag = new boolean[len];

		Arrays.sort(arr);
		for(int i = 0, j = arr.length - 1; i < j; i++, j--){
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		for(int i = len; i >= 2; i--){
			if(sum % i == 0){
				//Arrays.fill(flag, false);
				if(dfs(arr, flag, sum / i, i, sum / i, 0)){
					return i;
				}
			}
		}
		return 1;
	}

	public boolean dfs(int[] arr, boolean[] flag, int want, int group, int rest, int frm){
		if(rest == 0){
			group--;
			if(group == 0) return true;
			int i = 0;
			for(; i < flag.length && flag[i]; i++);
			flag[i] = true;
			return dfs(arr, flag, want, group, want - arr[i], i + 1);
		}else{
			for(int i = frm; i < flag.length; i++){
				if(flag[i]) continue;
				if(i > 0 && arr[i] == arr[i - 1] && !flag[i]) continue;

				flag[i] = true;
				if(dfs(arr, flag, want, group, rest - arr[i], i + 1)){
					return true;
				}else{
					flag[i] = false;
					if(rest == arr[i]){
						return false;
					}
				}
			}
			return false;
		}
	}
}