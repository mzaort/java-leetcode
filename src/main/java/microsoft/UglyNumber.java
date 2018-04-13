package microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UglyNumber {
	
	public static void main(String[] args) {
//		Integer i = new Integer(3), j = new Integer(3);
//		System.out.println(i.intValue() == j.intValue());
		UglyNumber u = new UglyNumber();
		List<Integer> l1 = u.findUgly(150);
		List<Integer> l2 = u.findUgly2(150);
		List<Integer> l3 = u.findUgly3(150);
		List<Integer> l4 = u.findUgly4(150);
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		
		System.out.println(isSame(l1, l2));
		System.out.println(isSame(l3, l2));
		System.out.println(isSame(l1, l4));
		System.out.println(isSame(l3, l4));
		
		
	}
	
	private static boolean isSame(List<Integer> l1, List<Integer> l2) {
		if(l1.size() != l2.size()) return false;
		int i = 0;
		for(; i < l1.size() && l1.get(i).intValue() == l2.get(i).intValue(); i++);
		return i == l1.size();
	}

	public List<Integer> findUgly(int n){
		assert(n > 0);
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 1, count = 0; ; i++){
			if(isUgly(i)){
				count++;
				res.add(i);
				if(count == n) break;
			}
		}
		return res;
	}

	private boolean isUgly(int i) {
		while(i % 2 == 0) i /= 2;
		while(i % 3 == 0) i /= 3;
		while(i % 5 == 0) i /= 5;
		return i == 1;
	}
	
	public List<Integer> findUgly2(int n){
		assert(n > 0);
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		for(int i = 1, count = 0; ; i++){
			if(set.contains(i)){
				count++;
				res.add(i);
				if(count == n) break;
				set.add(i * 2);
				set.add(i * 3);
				set.add(i * 5);
			}
		}
		return res;
	}
	
	public List<Integer> findUgly3(int n){
		assert(n > 0);
		List<Integer> res = new ArrayList<Integer>();
		LinkedList<Integer> q2 = new LinkedList<Integer>();
		LinkedList<Integer> q3 = new LinkedList<Integer>();
		LinkedList<Integer> q5 = new LinkedList<Integer>();
		res.add(1);
		q2.add(2);
		q3.add(3);
		q5.add(5);
		for(int i = 1; i < n; i++){
			int min = q2.peek();
			min = Math.min(min, q3.peek());
			min = Math.min(min, q5.peek());
			res.add(min);
			q2.offer(min * 2);
			q3.offer(min * 3);
			q5.offer(min * 5);
			if(min == q2.peek()) q2.poll();
			if(min == q3.peek()) q3.poll();
			if(min == q5.peek()) q5.poll();
		}
		return res;
	}
	
	public List<Integer> findUgly4(int n){
		assert(n > 0);
		List<Integer> res = new ArrayList<Integer>();
		LinkedList<Integer> q2 = new LinkedList<Integer>();
		LinkedList<Integer> q3 = new LinkedList<Integer>();
		LinkedList<Integer> q5 = new LinkedList<Integer>();
		q2.add(1);
		res.add(1);
		Integer tmp = null;
		for(int i = 1; i < n; i++){
			int min = Integer.MAX_VALUE;
			if((tmp = q2.peek()) != null && tmp * 2 < min) min = tmp * 2;
			if((tmp = q3.peek()) != null && tmp * 3 < min) min = tmp * 3;
			if((tmp = q5.peek()) != null && tmp * 5 < min) min = tmp * 5;
			res.add(min);
			q2.offer(min);
			if((tmp = q2.peek()) != null && tmp * 2 == min)	q3.offer(q2.poll());
			if((tmp = q3.peek()) != null && tmp * 3 == min) q5.offer(q3.poll());
			if((tmp = q5.peek()) != null && tmp * 5 == min) q5.poll();
		}
		return res;
	}
}
