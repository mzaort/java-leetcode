package microsoft;

import java.util.Random;
public class ReserviorSampling{
	public int[] sample(int n, int k){
		assert (k > 0 && n >= k);

		int[] res = new int[k];
		for(int i = 0; i < k; i++){
			res[i] = i;
		}

		for(int i = k; i < n; i++){
			int j = (int) (Math.random() * (i + 1));
			if(j < k){
				int h = (int) (Math.random() * k);
				res[h] = i;
			}
		}
		
		return res;
	}
	
	public int[] sample2(int n, int k){
		assert (k > 0 && n >= k);
		int[] res = new int[k];
		for(int i = 0; i < k; i++) res[i] = i;
		Random r = new Random();
		for(int i = k; i < n; i++){
			int j = r.nextInt(i + 1);
			if(j < k){
				int h = r.nextInt(k);
				res[h] = i;
			}
		}
		return res;
	}
}