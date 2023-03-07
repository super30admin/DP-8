// Approach: Bottom up DP - start from the 2nd last row
// 1. Calculate and set value of this element as (this value + Min(of 2 elements just below it))
// 2. Continue doing this until the top row
// 3. Return the top element's value
// Time: O(n^2) for n rows and n columns in the triangle
// Space: O(1)

import java.util.*;

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for (int i = n-2; i>=0; i--) {
            for (int j = 0; j<=i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) +
                        Math.min(triangle.get(i+1).get(j+1), triangle.get(i+1).get(j)));
            }
        }
        return triangle.get(0).get(0);
    }
}