import java.util.List;

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Start bottom up and mutate the triangle
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for (int i = n - 2; i >= 0; i--) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++) {
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                int curr = triangle.get(i).get(j);
                triangle.get(i).set(j, min + curr);
            }
        }

        return triangle.get(0).get(0);
    }
    public static void main(String[] args) {
        // Your code here
    }
}