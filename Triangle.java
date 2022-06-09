// O(n^2) time complexity, operations for each cell in input triangle of n rows and n cols (we start at row 1)
// O(1) space: overwrite input
 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++){
            for (int col = 0; col <= row; col++){
                int smallestAbove = Integer.MAX_VALUE;
                if (col > 0){ // only if col == row or if two cells above it
                    smallestAbove = triangle.get(row - 1).get(col - 1);
                }
                
                if (col < row){ // only if col == 0 or if there is two cells above it
                    smallestAbove = Math.min(smallestAbove, triangle.get(row - 1).get(col));
                }
                
                int path = smallestAbove + triangle.get(row).get(col);
                triangle.get(row).set(col, path);
                
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}