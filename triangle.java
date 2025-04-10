// TC: O(n^2)
// SC: O(1) - in-place modification of the triangle
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        
        // Update the triangle in-place with cumulative path sums.
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                if (j == 0) {
                    // First element in the row, only one adjacent element from above.
                    currRow.set(j, currRow.get(j) + triangle.get(i - 1).get(j));
                } else if (j == currRow.size() - 1) {
                    // Last element in the row, only one adjacent element from above.
                    currRow.set(j, currRow.get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    // Middle element, choose the minimum of the two adjacent elements.
                    currRow.set(j, currRow.get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                }
            }
        }
        
        // The answer is the smallest value in the last row.
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int minTotal = Integer.MAX_VALUE;
        for (int num : lastRow) {
            minTotal = Math.min(minTotal, num);
        }
        
        return minTotal;
    }
}
