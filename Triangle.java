package dp8;

import java.util.*;

public class Triangle {
	
	public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        
        if(triangle.size() == 0) return 0;
        
        for(int i = m - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                List<Integer> nextRow = triangle.get(i + 1);
            // for min path sum
                int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                
                // for max path sum
                // int sum = Math.max(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                 
                triangle.get(i).set(j, sum);
            
            }
        }
        return triangle.get(0).get(0);
    }
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(new ArrayList<>(Arrays.asList(2)));
		triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
		triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
		triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
		Triangle obj = new Triangle();
		System.out.println(obj.minimumTotal(triangle));
	
	}
}


