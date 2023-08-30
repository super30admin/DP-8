import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class TriangleDPArr2D {

        // Bottom Up Dynamic Programming with 2D DP array with path - Time O(n*n) and Space O(n*n)

        public int minimumTotal(List<List<Integer>> triangle) {

            // null case
            if(triangle == null)     return 0;

            int n = triangle.size();

            int[][] dp = new int[n][n];
            int[][] path = new int[n][n];

            for(int j = 0; j < n; j++) {

                dp[n-1][j] = triangle.get(n-1).get(j);
            }

            // nested loop to access an element in triangle
            for(int i = n-2; i >= 0; i--) {                // O(n*n)
                for(int j = 0; j <= i; j++) {

                    // update path array with indices of path
                    if(dp[i][j] < dp[i][j+1]) {

                        path[i][j] = j;
                    }

                    else {

                        path[i][j] = j+1;
                    }


                    //
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }

            // print path
            System.out.println(Arrays.deepToString(path));

            // output
            return dp[0][0];
        }

        public static void main(String[] args) {

            TriangleDPArr2D obj = new TriangleDPArr2D();

            Scanner scanner = new Scanner(System.in);
            System.out.println("height of triangle: ");
            int n = scanner.nextInt();

            List<List<Integer>> triangle = new ArrayList<>();
            System.out.println("triangle: ");

            for(int i = 0; i < n; i++) {

                List<Integer> row = new ArrayList<>();

                System.out.println("level " + (i+1));
                for(int j = 0; j <= i; j++) {

                    row.add(scanner.nextInt());
                }

                triangle.add(row);
            }

            int answer = obj.minimumTotal(triangle);
            System.out.println("the minimum path sum from top to bottom: " + answer);

        }

}

/*
Time Complexity = O(n*n)
Space Complexity = O(n*n)

*/