package interview2015;

public class NextPermutation {
    public void nextPermutation(int[] num) {
        int i = num.length - 2;
        for(; i >= 0 && num[i] >= num[i + 1]; i--);
        for(int k = i + 1, j = num.length - 1; k < j; k++, j--) swap(num, k, j);
        if(i >= 0) swap(num, i, search(num, i + 1, num.length - 1, num[i]));
    }

	private int search(int[] num, int i, int j, int target) {
		while(i <= j){
			int mid = i + ((j - i) >>> 1);
			if(target < num[mid]) j = mid - 1;
			else i = mid + 1;
		}
		return i;
	}

	private void swap(int[] num, int k, int j) {
		int tmp = num[k];
		num[k] = num[j];
		num[j] = tmp;
	}
}
