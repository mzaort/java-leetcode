package googleCode;

public class NextPermutation {
    public void nextPermutation(int[] num) {
    	int cur = num.length - 2;
    	for(; cur >= 0 && num[cur] >= num[cur + 1]; cur--);
    	for(int i = cur + 1, j = num.length - 1; i < j; swap(num, i++, j--));
    	if(cur >= 0){
    		swap(num, cur, searchRight(num, cur + 1, num.length - 1, num[cur]));
    	}
    }

	private void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	private int searchRight(int[] num, int i, int j, int target) {
		while(i <= j){
			int mid = i + ((j - i) >>> 1);
			if(num[mid] <= target) i = mid + 1;
			else j = mid - 1;
		}
		return i;
	}
}
