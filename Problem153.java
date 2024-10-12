//TC: O(n^2)
//SC: O(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Start from the second last row and move upwards
        for (int row = n - 2; row >= 0; row--) {
            // For each element in the current row
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // Update the current element to the minimum sum of the adjacent elements in the row below
                int minPath = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, triangle.get(row).get(col) + minPath);
            }
        }
        
        // The top element will contain the minimum path sum
        return triangle.get(0).get(0);
    }
}
