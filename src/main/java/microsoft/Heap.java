package microsoft;

public class Heap {
	public static void maxHeapify(int[] arr, int len, int i){
		assert(i >= 0 && i < len && len <= arr.length);
				
		while(true){
			int large = i;
			int j = (i << 1) + 1;
			if(j < len && arr[j] > arr[large]){
				large = j;
			}
			j++;
			if(j < len && arr[j] > arr[large]){
				large = j;
			}
			if(i == large){
				break;
			}else{
				swap(arr, i, large);
				i = large;
			}
		}
	}
	
	public static void minHeapify(int[] arr, int len, int i){
		assert(i >= 0 && i < len && len <= arr.length);
				
		while(true){
			int small = i;
			int j = (i << 1) + 1;
			if(j < len && arr[j] < arr[small]){
				small = j;
			}
			j++;
			if(j < len && arr[j] < arr[small]){
				small = j;
			}
			if(i == small){
				break;
			}else{
				swap(arr, i, small);
				i = small;
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void maxHeapify(int[] arr, int len){
		assert(len >= 0 && len <= arr.length);
		if(len < 2) return;
		for(int i = (len - 2) / 2; i >= 0; i--){
			maxHeapify(arr, len, i);
		}
	}
	
	public static void minHeapify(int[] arr, int len){
		assert(len >= 0 && len <= arr.length);
		if(len < 2) return;
		for(int i = (len - 2) / 2; i >= 0; i--){
			minHeapify(arr, len, i);
		}
	}
	
	public static void maxHeapSort(int[] arr){
		maxHeapify(arr, arr.length);
		for(int i = arr.length; i > 1; i--){
			swap(arr, i - 1, 0);
			maxHeapify(arr, i - 1, 0);
		}
	}
	
	public static void minHeapSort(int[] arr){
		minHeapify(arr, arr.length);
		for(int i = arr.length; i > 1; i--){
			swap(arr, i - 1, 0);
			minHeapify(arr, i - 1, 0);
		}
	}
	
	public static int[] minTopK(int[] arr, int k){
		assert(k > 0 && k < arr.length);
		
		int[] res = new int[k];
		for(int i = 0; i < k; i++){
			res[i] = arr[i];
		}
		
		maxHeapify(res, k);
		for(int i = k; i < arr.length; i++){
			if(arr[i] < res[0]){
				res[0] = arr[i];
				maxHeapify(res, k, 0);
			}
		}
		
		return res;
	}
	
	public static int[] maxTopK(int[] arr, int k){
		assert(k > 0 && k < arr.length);
		
		int[] res = new int[k];
		for(int i = 0; i < k; i++){
			res[i] = arr[i];
		}
		
		minHeapify(res, k);
		for(int i = k; i < arr.length; i++){
			if(arr[i] > res[0]){
				res[0] = arr[i];
				minHeapify(res, k, 0);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3,2, 8, 9, 10, 1, 4, 2,3};
		for(int e : arr){
			System.out.print(e + "\t");
		}
		System.out.println();
		Heap.maxHeapSort(arr);
		for(int e : arr){
			System.out.print(e + "\t");
		}
		System.out.println();
		Heap.minHeapSort(arr);
		for(int e : arr){
			System.out.print(e + "\t");
		}
		System.out.println();
		
		int[] res = Heap.maxTopK(arr, 3);
		for(int i = 0; i < 3; i++){
			System.out.print(res[i] + "\t");
		}
		System.out.println();
		
		res = Heap.minTopK(arr, 5);
		for(int i = 0; i < 5; i++){
			System.out.print(res[i] + "\t");
		}
		System.out.println();

	}
}
