// Time Complexity: O(n*m) all elements in list
// Space Complexity: O(1)
// Bottom Up
public class Triangle
{
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int n = triangle.size();
        // start from second last row
        for(int i = n-2; i >= 0 ; i--)
        {
            for(int j = 0 ; j < triangle.get(i).size(); j++)
            {
                triangle.get(i).set(j, triangle.get(i).get(j) +
                Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1))
                );
            }
        }
        return triangle.get(0).get(0);
    }
}
// Time Complexity: O(n*m) all elements in list
// Space Complexity: O(1)
// Top Down
public class Triangle
{
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int n = triangle.size();
        // start from second row
        for(int i = 1; i < n ; i++)
        {
            for(int j = 0 ; j < triangle.get(i).size(); j++)
            {
                if(j == 0)
                {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                }
                else if(j == i)
                {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                }
                else
                {
                    triangle.get(i).set(j, triangle.get(i).get(j) +
                                Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1))
                    );
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0 ; j < n ; j ++)
        {
            min = Math.min(min, triangle.get(n-1).get(j));
        }
        return min;
    }
}