// Time Complexity : O(n^2) n is the length of last row.
// Space Complexity : O(1) updating in the same triangle, not using extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [] arr = new int[triangle.size()];

        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }

        return triangle.get(0).get(0);
    }
}