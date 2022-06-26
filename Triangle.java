/*
 * TC = O(N)
 * SC = O(1)
 * 
 * Approach: We maintain inplace sum. 
 */

import java.util.*;
public class Triangle {
    
    public static int minimumTotal(List<List<Integer>> triangle)
    {
        if(triangle == null || triangle.size() == 0) return 0;

        int n = triangle.size();
        
        for(int i = n -2;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            {
                triangle.get(i).set(j,triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        
        return triangle.get(0).get(0);
    }

    public static void main(String args[])
    {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> last = new ArrayList<>();
        last.add(4);
        last.add(1);
        last.add(8);
        last.add(3);

        

        List<Integer> last2 = new ArrayList<>();
        last2.add(6);
        last2.add(5);
        last2.add(7);

        

        List<Integer> last3 = new ArrayList<>();
        last3.add(3);
        last3.add(4);

        

        List<Integer> top = new ArrayList<>();
        top.add(2);

        triangle.add(top);
        triangle.add(last3);
        triangle.add(last2);
        triangle.add(last);

        for(List<Integer> li: triangle)
        {
            System.out.println(li);
        }

        System.out.println(minimumTotal(triangle));
    }
}
