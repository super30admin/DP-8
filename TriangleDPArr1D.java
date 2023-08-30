import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class TriangleDPArr1D {

        // Bottom Up Dynamic Programming with 1D DP array - Time O(n*n) and Space O(n)

        public int minimumTotal(List<List<Integer>> triangle) {

            // null case
            if(triangle == null)     return 0;

            int n = triangle.size();

            int[] dp = new int[n];

            for(int j = 0; j < n; j++) {

                dp[j] = triangle.get(n-1).get(j);
            }

            // nested loop to access an element in triangle
            for(int i = n-2; i >= 0; i--) {                // O(n*n)
                for(int j = 0; j <= i; j++) {

                    //
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                }
            }

            // output
            return dp[0];
        }

        public static void main(String[] args) {

            TriangleDPArr1D obj = new TriangleDPArr1D();
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
Space Complexity = O(n)
*/