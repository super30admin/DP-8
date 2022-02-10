// Time Complexity : O(n), where n is the number of elements in the triangle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// This can be implemented in a top down or bottom up manner
// Bottom Up Approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (triangle == null || n == 0) return 0;

        for (int i = n-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int updatedVal = triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, updatedVal);
            }
        }

        return triangle.get(0).get(0);
    }
}

// Top Down Approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (triangle == null || n == 0) return 0;

        // Top down
        // We add the min value from the top elements to the current element,
        // and at the end we iterate over the leaf nodes and get the min value and return it.
        for (int i=1; i<n; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) {         // first elements
                    int value = triangle.get(i).get(j) + triangle.get(i-1).get(j);
                    triangle.get(i).set(j, value);
                }
                else if (j==i) {    // last elements
                    int value = triangle.get(i).get(j) + triangle.get(i-1).get(j-1);
                    triangle.get(i).set(j, value);
                }
                else {              // in-between elements
                    int value = triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j));
                    triangle.get(i).set(j, value);
                }
            }
        }

        int min=Integer.MAX_VALUE;
        for (int i=0; i < triangle.get(n-1).size(); i++) {
            min = Math.min(min, triangle.get(n-1).get(i));
        }

        return min;
    }
}