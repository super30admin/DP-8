import java.util.List;
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class TriangleUsingBottomUPDP2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m =triangle.size();

        for(int i=1; i<m; i++){
            for(int j=0; j<= i; j++){
                if(j==0){
                    // only first to get from prev row
                    int currVal = triangle.get(i).get(j);
                    int prevValue = triangle.get(i-1).get(j);
                    triangle.get(i).set(j, currVal+prevValue);
                }else if(j == i){
                    // only last to get from prev row
                    int currVal = triangle.get(i).get(j);
                    int prevValue = triangle.get(i-1).get(j-1);
                    triangle.get(i).set(j, currVal+prevValue);
                }else{
                    //get j and j-1 from prev row
                    // only last to get from prev row
                    int currVal = triangle.get(i).get(j);
                    int prevValue = Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1));
                    triangle.get(i).set(j, currVal+prevValue);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<triangle.get(m-1).size(); i++){
            result = Math.min(result, triangle.get(m-1).get(i));
        }

        return result;
    }
}
