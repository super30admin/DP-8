import java.util.List;
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class TriangleUsingBottomUpDp1 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        for(int i=m-2; i>=0; i--){
            System.out.println(i);
            for(int j=0; j<=i; j++){
                int minValue = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                int re = triangle.get(i).get(j)+minValue;
                triangle.get(i).set(j,re);
            }
        }

        return triangle.get(0).get(0);

    }
}
