//TC = O(n) going through n lists
//SC = O(1) as modifying given list
// Was able to run in LeetCode = yes

package com.madhurima;

import java.util.List;

public class TriangleMinimumPathSum {
}

class TriangleMinimumPathSumDownUp {

    //down up
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int n = triangle.size();

        for(int i = n-2; i >= 0; i--){ //start from 2nd last row
            for(int j = 0; j <= i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(
                        triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)
                ));
            }
        }

        return triangle.get(0).get(0);

    }
}

class TriangleMinimumPathSumUpDown{

    //up down
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int n = triangle.size();

        for(int i = 1; i < n; i++){ //start from 2nd row, will have access to row above it
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                }else if(j == i){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(i-1));
                }else{
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(
                            triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)
                    ));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            min = Math.min(min, triangle.get(n-1).get(j));
        }

        return min;

    }
}
