//Time complexity is O(N) where N is the number of elements in triangle
//Space complexity is O(1)
//This solution is submitted on leetcode

import java.util.List;

public class BigN151MinimumPathInaTriangle {
	class Solution {
		public int minimumTotal(List<List<Integer>> triangle) {
			// edge case
			if (triangle == null || triangle.size() == 0)
				return 0;
			int size = triangle.size();
			for (int i = size - 2; i >= 0; i--) { 
				List<Integer> temp = triangle.get(i + 1); 
				for (int j = 0; j <= i; j++) {
					int sum = Math.min(temp.get(j), temp.get(j + 1)) + triangle.get(i).get(j);
					triangle.get(i).set(j, sum);
				}
			}
			return triangle.get(0).get(0);
		}
	}
}