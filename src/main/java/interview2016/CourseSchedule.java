package interview2016;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		assert (prerequisites != null && numCourses >= 0);
		List<List<Integer>> matrix = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			matrix.add(new ArrayList<Integer>());
		}
		for (int[] e : prerequisites) {
			matrix.get(e[0]).add(e[1]);
		}
		return !hasCycle(matrix, new int[numCourses]);
	}

	private boolean hasCycle(List<List<Integer>> matrix, int[] color) {
		for (int i = 0; i < color.length; i++) {
			if (color[i] == 0) {
				if (hasCycle(matrix, color, i)) return true;
			}
		}
		return false;
	}

	private boolean hasCycle(List<List<Integer>> matrix, int[] color, int i) {
		color[i] = 1;
		for (int j : matrix.get(i)) {
			if (color[j] == 0) {
				if (hasCycle(matrix, color, j)) return true;
			} else if (color[j] == 1) return true;
		}
		color[i] = 2;
		return false;
	}

}
