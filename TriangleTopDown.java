import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class TriangleTopDown {

        // Top Down Dynamic Programming - Time O(n*n) and Space O(1)

        public int minimumTotal(List<List<Integer>> triangle) {

            // null case
            if(triangle == null)     return 0;

            int n = triangle.size();

            // nested loop to access an element in triangle
            for(int i = 1; i < n; i++) {                // O(n*n)
                for(int j = 0; j <= i; j++) {

                    // if first element in a row
                    if(j == 0) {

                        // mutate by adding first element in top row
                        triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                    }

                    // if last element in a row
                    else if(j == i){

                        // mutate by adding last element in top row
                        triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                    }

                    // if middle element in a row
                    else {

                        // mutate by adding minimum of two allowed elements in top row
                        triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
                    }
                }
            }

            // find minimum sum by iterating over last row
            int minSum = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {

                minSum = Math.min(minSum, triangle.get(n-1).get(j));
            }

            // output
            return minSum;
        }

        public static void main(String[] args) {

            TriangleTopDown obj = new TriangleTopDown();

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