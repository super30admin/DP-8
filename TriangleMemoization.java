import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class TriangleMemoization {

        // Memoization - Time O(n*n) and Space O(n*n)

        List<List<Integer>> triangle;
        Integer[][] memo;
        int n;

        public int minimumTotal(List<List<Integer>> triangle) {

            this.triangle = triangle;
            n = triangle.size();
            this.memo = new Integer[n][n];

            return helper(0, 0);
        }

        public int helper(int r, int c) {

            //base
            if(memo[r][c] != null) {

                // return memoized cache if recursion done already
                return memo[r][c];
            }

            // terminate recursion at last row
            if(r == n-1) {

                // return last row as it is in triangle
                return triangle.get(r).get(c);
            }

            // logic
            // recurse
            int adjLeft = helper(r+1, c);
            int adjRight = helper(r+1, c+1);

            // action
            memo[r][c] = triangle.get(r).get(c) + Math.min(adjLeft, adjRight);

            return memo[r][c];
        }

        public static void main(String[] args) {

            TriangleMemoization obj = new TriangleMemoization();

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
Space Complexity = O(n*n) - recursive stack space, memoization array space
*/