import java.util.List;

public class Problem2 {
    // Bottom-up Approach
    // TC : O(n^2) // where triangle with n raws and n columns
    // SC : O(1)
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int m = triangle.size();
        //int n = triangle.get(m).size();

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)
                        + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    // Top-down approach
    // TC : O(n^2)
    // SC : O(1)
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int m = triangle.size();

        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j)
                            + triangle.get(i - 1).get(j));

                } else if (j == i) {
                    triangle.get(i).set(j, triangle.get(i).get(j)
                            + triangle.get(i - 1).get(j - 1));

                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j)
                            + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, triangle.get(m - 1).get(i));
        }
        return min;
    }
}
