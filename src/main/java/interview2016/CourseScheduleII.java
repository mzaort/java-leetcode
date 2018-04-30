package interview2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

	public static void main(String[] args) {
		CourseScheduleII c2 = new CourseScheduleII();
		int[][] numCourses = { { 0, 1 } };
		System.out.println(Arrays.toString(c2.findOrder(2, numCourses)));
	}

	public int[] findOrder2(int numCourses, int[][] prerequisites) {
		List<Set<Integer>> adjLists = new ArrayList<Set<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			adjLists.add(new HashSet<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		int[] indegrees = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			for (int x : adjLists.get(i)) {
				indegrees[x]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegrees[i] == 0) {
				queue.offer(i);
			}
		}

		int[] res = new int[numCourses];
		int count = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int x : adjLists.get(cur)) {
				indegrees[x]--;
				if (indegrees[x] == 0) {
					queue.offer(x);
				}
			}
			res[count++] = cur;
		}

		if (count == numCourses) return res;
		return new int[0];
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] e : prerequisites) {
			graph.get(e[0]).add(e[1]);
		}
		LinkedList<Integer> courses = new LinkedList<>();
		if (isTopological(courses, graph, new int[numCourses])) {
			int[] result = new int[numCourses];
			Iterator<Integer> iterator = courses.iterator();
			for (int i = numCourses - 1; i >= 0 && iterator.hasNext(); i--) {
				result[i] = iterator.next();
			}
			return result;
		}
		return new int[0];
	}

	private boolean isTopological(LinkedList<Integer> courses, List<List<Integer>> graph, int[] color) {
		for (int i = 0; i < color.length; i++) {
			if (color[i] == 0) {
				if (!isTopological(courses, graph, color, i)) return false;
			}
		}
		return true;
	}

	private boolean isTopological(LinkedList<Integer> courses, List<List<Integer>> graph, int[] color, int i) {
		color[i] = 1;
		for (Integer e : graph.get(i)) {
			if (color[e] == 0) {
				if (!isTopological(courses, graph, color, e)) return false;
			} else if (color[e] == 1) return false;
		}
		color[i] = 2;
		courses.offerFirst(i);
		return true;
	}

	public int[] findOrder3(int numCourses, int[][] prerequisites) {
		ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>(numCourses);
		for (int i = 0; i < numCourses; i++)
			graph.add(new LinkedList<Integer>());
		for (int[] e : prerequisites)
			graph.get(e[1]).add(e[0]);
		LinkedList<Integer> res = new LinkedList<Integer>();
		return isTopological3(res, graph, new int[numCourses]) ? res.stream().mapToInt(e -> e.intValue()).toArray()
				: new int[0];
	}

	private boolean isTopological3(LinkedList<Integer> res, ArrayList<LinkedList<Integer>> graph, int[] color) {
		for (int i = 0; i < color.length; i++) {
			if (color[i] == 0) {
				if (!isTopological3(res, graph, color, i)) return false;
			}
		}
		return true;
	}

	private boolean isTopological3(LinkedList<Integer> res, ArrayList<LinkedList<Integer>> graph, int[] color, int i) {
		color[i] = 1;
		for (int e : graph.get(i)) {
			if (color[e] == 0) {
				if (!isTopological3(res, graph, color, e)) return false;
			} else if (color[e] == 1) { return false; }
		}
		res.offerFirst(i);
		color[i] = 2;
		return true;
	}

}
