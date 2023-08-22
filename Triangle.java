import java.util.List;

public class Triangle {

    //Time Complexity: O(N2)
    //Space Complexity: O(N2)
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][ triangle.get(triangle.size()-1).size()];

        for(int i =0; i< memo.length; i++){
            for(int j = 0; j< memo[0].length; j++){
                memo[i][j] = -1;
            }

        }
        return helper(triangle, 0, 0);
    }

    private int helper(List<List<Integer>> triangle, int row, int col){

        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(memo[row][col] != -1 ){
            return memo[row][col];
        }
        //case 1
        int case1 = helper(triangle, row+1, col);
        //case 2
        int case2 = helper(triangle, row+1, col+1);

        memo[row][col] = triangle.get(row).get(col)+ Math.min(case1, case2);
        return memo[row][col];
    }
}
