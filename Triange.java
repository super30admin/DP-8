/**
 * Uses bottom-up dynamic programming where each cell stores the minimum path sum
 * to reach that position using values from the previous row.
 * Time Complexity: O(n²) since every triangle element is processed once.
 * Space Complexity: O(n) because only the previous row is stored at any time.
 */

public class Triange {
        public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevRow = triangle.get(0);
        List<Integer> currentRow = triangle.get(0);
        for (int row = 1; row < triangle.size(); row++) {
            currentRow = new ArrayList<>();
            for (int j = 0; j < triangle.get(row).size(); j++) {
                int ans = triangle.get(row).get(j);
                int min = Integer.MAX_VALUE;
                if (j<prevRow.size()) {
                    min = Math.min(min, prevRow.get(j));
                }
                if (j-1 >=0) {
                    min = Math.min(prevRow.get(j-1), min);
                }
                currentRow.add(ans+min);
            }
            prevRow = currentRow;
        }

        return Collections.min(currentRow);
    }
    
}
