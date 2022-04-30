import java.util.*;
/*
Time Complexity: O(N*N) N is the size of the triangle
Space Complexity: O(N), Size of DP memoization array
Run on leetcode: Yes
Any Difficulties: No

Approach: Attempted after discussed in the class
1. Starting from the last row ans trying to choose element which is minimum from its consecutive element and
maintaining dp states for that.
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle){
        if(triangle.size() == 0){
            return 0;
        }

        int rows = triangle.size();
        int[] dp = new int[rows+1];

        for(int i = rows-1; i>=0; i--){
            for(int j = 0; j<=i; j++){
                dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
    public static void main(String[] args){
        List<Integer> row1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(3,4));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(4,1,8,3));

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);

        System.out.println("Minimum Total: "+ minimumTotal(triangle));

    }
}
