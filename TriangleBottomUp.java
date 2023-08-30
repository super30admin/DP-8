import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class TriangleBottomUp {

        // Bottom Up Dynamic Programming - Time O(n*n) and Space O(1)

        public int minimumTotal(List<List<Integer>> triangle) {

            // null case
            if(triangle == null)     return 0;

            int n = triangle.size();

            // nested loop to access an element in triangle
            for(int i = n-2; i >= 0; i--) {                // O(n*n)
                for(int j = 0; j <= i; j++) {

                    // mutate the element in current row by adding minimum of two allowed elements in the row below to itself
                    triangle.get(i).set(j, triangle.get(i).get(j) +
                            Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
                }
            }

            // output root of triangle
            return triangle.get(0).get(0);
        }

        public static void main(String[] args) {

            TriangleBottomUp obj = new TriangleBottomUp();

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
Space Complexity = O(1)
*/