//The approach here is to iterate from bottom to top from last but one row and at each index modify the existing value at the triangle to save space.
//At each index, we take the minimum of the two values with same column or next column from the next row and the current value at the current index and replace the old value with the result at the same index.
//Our result will be in the first row first column
//Time Complexity: O(n^2)
//Space Complexity: O(1)
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j <= i; j++){
                int re = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j,re);
            }
        }
        return triangle.get(0).get(0);
    }
}
