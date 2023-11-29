//TC will be O(m * n)
//SC will be O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int m = triangle.size();
        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }


    public static void main(String[] args){
        Triangle obj = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(obj.minimumTotal(triangle));
    }
}