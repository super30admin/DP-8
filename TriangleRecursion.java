import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class TriangleRecursion {

        // Recursion - Time O(2^n) and Space O(n)

        List<List<Integer>> triangle;
        public int minimumTotal(List<List<Integer>> triangle) {

            this.triangle = triangle;

            return helper(0, 0);
        }

        public int helper(int r, int c) {

            //base
            // terminate recursion at last row
            if(r == triangle.size()-1) {

                // return last row as it is in triangle
                return triangle.get(r).get(c);
            }

            // logic
            // recurse
            int adjLeft = helper(r+1, c);
            int adjRight = helper(r+1, c+1);

            // action
            return triangle.get(r).get(c) + Math.min(adjLeft, adjRight);
        }

        public static void main(String[] args) {

            TriangleRecursion obj = new TriangleRecursion();

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
Time Complexity = O(2^n)
Space Complexity = O(n) - recursive stack space
 */