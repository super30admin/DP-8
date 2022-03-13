// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {

    //top down dp
    public int minimumTotal(List<List<Integer>> triangle) {
        //null case
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;

        int n = triangle.size();
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){ //j<=i coz 2nd row as 2 elements and so on

                if(j == 0){
                    //first index - add it with 0th index of prev row
                    triangle.get(i)
                            .set(j,
                                    triangle.get(i).get(j)
                                            + triangle.get(i-1).get(j));
                }else if(j == i){
                    //last element - add it with last index of prev row
                    triangle.get(i)
                            .set(j,
                                    triangle.get(i).get(j)
                                            + triangle.get(i-1).get(j-1));
                }else{
                    //in between - min of parents
                    triangle.get(i)
                            .set(j,
                                    triangle.get(i).get(j)
                                            + Math.min(triangle.get(i-1).get(j-1),
                                            triangle.get(i-1).get(j)));
                }
            }
        }

        for(int i = 0; i < n; i++){
            min = Math.min(min,triangle.get(n-1).get(i));
        }
        return min;
    }


    //Bottom up dp
    public int minimumTotal2(List<List<Integer>> triangle) {
        //null case
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;

        int n = triangle.size();
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){ //j<=i coz 2nd row as 2 elements and so on

                if(j == 0){
                    //first index - add it with 0th index of prev row
                    triangle.get(i)
                            .set(j,
                                    triangle.get(i).get(j)
                                            + triangle.get(i-1).get(j));
                }else if(j == i){
                    //last element - add it with last index of prev row
                    triangle.get(i)
                            .set(j,
                                    triangle.get(i).get(j)
                                            + triangle.get(i-1).get(j-1));
                }else{
                    //in between - min of parents
                    triangle.get(i)
                            .set(j,
                                    triangle.get(i).get(j)
                                            + Math.min(triangle.get(i-1).get(j-1),
                                            triangle.get(i-1).get(j)));
                }
            }
        }

        for(int i = 0; i < n; i++){
            min = Math.min(min,triangle.get(n-1).get(i));
        }
        return min;
    }

}