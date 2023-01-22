import java.util.List;

public class Triangle {


    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size() == 0 ) return 0;
        int n = triangle.size();
        for(int i = 1;i<n;i++){
            for(int j = 0; j<=i;j++){
                if(j==0) triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i-1).get(j));
                else if(j==i) triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(i-1));
                else triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n;i++){
            min = Math.min(min, triangle.get(n-1).get(i));
        }
        return min;
    }


    //TC - O(n) SC O(1)
/*
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null ) return 0;
        int n = triangle.size();
        for(int i = n-2; i>=0;i--){
            for(int j = 0; j<=i;j++){
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j+1),triangle.get(i+1).get(j)));
            }
        }
        return triangle.get(0).get(0);
    }*/
}
