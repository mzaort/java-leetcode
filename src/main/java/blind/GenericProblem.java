package blind;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericProblem {
	public static void main(String[] args) {
		Integer[] i = new Integer[10];
		Arrays.fill(i, new Integer(2));
		GenericProblem gp = new GenericProblem();
		System.out.println(gp.mid(i));
		
		Integer[] x = gp.create(Integer.valueOf(10));
		x[0] = x[1] = 10;
		System.out.println(Arrays.toString(x));
	}
	
	public <T> T mid(T[] t){
		return t[t.length / 2];
	}
	
	@SuppressWarnings("unchecked")
	public <T> T[] create(T t){
		return (T[]) Array.newInstance(t.getClass(), 10);
	}
}
