import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Tc: O(n^2) Sc: O(n)
        int n = triangle.size();

        int[] minPathSums = new int[n];

        for (int i = 0; i < n; i++) {
            minPathSums[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                minPathSums[j] = Math.min(minPathSums[j], minPathSums[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minPathSums[0];
    }
}

/*
 * class Solution {
 * public int minimumTotal(List<List<Integer>> triangle) {
 * // Tc: O(m*n) Sc: O(1)
 * int n = triangle.size();
 * for (int i = n - 2; i >= 0; i--) {
 * for (int j = 0; j < triangle.get(i).size(); j++) {
 * int minPath = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j
 * + 1));
 * triangle.get(i).set(j, triangle.get(i).get(j) + minPath);
 * }
 * }
 * return triangle.get(0).get(0);
 * }
 * }
 * 
 */