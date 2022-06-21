/*
Problem: https://leetcode.com/problems/triangle/
TC: O(n * m)
S: O(1) since we're modifying the original array
*/

// Approach 1: bottom-up
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int n = triangle.size();
        
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                int min = triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j + 1));
                triangle.get(i).set(j, min);
            }
        }
        
        return triangle.get(0).get(0);
    }
}

// Approach 2: top-down
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int n = triangle.size();
        
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                } else if (j == i) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j - 1));
                } else {
                    int min = triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1));
                    triangle.get(i).set(j, min);
                }
            }
        }
        
        int min = triangle.get(n - 1).get(0);
        for (int i = 1; i < n; ++i) {
            min = Math.min(min, triangle.get(n-1).get(i));
        }
        
        return min;
    }
}