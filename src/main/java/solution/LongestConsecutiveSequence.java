package solution;

import java.util.HashSet;

public class LongestConsecutiveSequence{
	
	public static void main(String[] args) {
		int[] num = { 1, 0, -1};
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		System.out.println(lcs.longestConsecutive(num));
	}
	
	public int longestConsecutive(int[] num) {
		int len = num.length;
		if(len <= 1) return len;

		HashSet<Integer> hsi = new HashSet<Integer>();
		for(int e : num){
			hsi.add(e);
		}
		int ans = 0;
		for(int e : num){
			if(hsi.contains(e)){
				hsi.remove(e);
				
				int k = e - 1;
				while(hsi.contains(k)){
					hsi.remove(k);
					k--;
				}

				int h = e + 1;
				while(hsi.contains(h)){
					hsi.remove(h);
					h++;
				}
				
				int tmp = h - k - 1;
				if(ans < tmp){
					ans = tmp;
				}
			}
		}
		return ans;
	}
}