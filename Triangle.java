// Time Complexity: O(n^2)
// Space Complexity:  O(1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle){
        int n = triangle.size();


        // start from second last row and move upwards
        for(int row = n - 2 ;row >=0; row-- ){
            for(int col =0; col< triangle.get(row).size(); col ++){
                // update the current cell with minimum path sum
                int below = triangle.get(row +1).get(col);
                int belowRight = triangle.get(row +1).get(col +1);
                triangle.get(row).set(col, triangle.get(row).get(col) + Math.min(below, belowRight));
            }
        }

        return triangle.get(0).get(0);

    }

    public static void main( String [] args){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        Triangle solution = new Triangle();
        int result = solution.minimumTotal(triangle);

        System.out.println("The minimum path sum is: " + result);
    }
}
