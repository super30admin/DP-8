// Time Complexity: O(N) where N is the total number of elements in the triangle (≈ O(n^2) for n rows).
// Space Complexity: O(1) extra – in-place DP updates within the given triangle.

// Start from the second-last row and move upward.
// For each cell (i, j), set triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1]).
// After finishing, the top cell triangle[0][0] holds the minimum path sum; return it.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j,
                    triangle.get(i).get(j) + 
                    Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1))
                );
            }
        }

        return triangle.get(0).get(0);
    }
}
