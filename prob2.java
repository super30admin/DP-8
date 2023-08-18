// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<int[]> ways = new ArrayList<>();
        int capacity = 3;
        int[] tmp;
        ways.add(new int[]{Integer.MAX_VALUE, triangle.get(0).get(0),Integer.MAX_VALUE});
        for (int i = 1; i < triangle.size(); i++)
        {
            capacity++;
            tmp = new int[capacity];
            tmp[0] = Integer.MAX_VALUE;
            tmp[capacity - 1] = Integer.MAX_VALUE;
            for (int j = 1; j < capacity - 1; j++)
                tmp[j] = (Math.min(ways.get(i - 1)[j - 1], ways.get(i - 1)[j]) + triangle.get(i).get(j - 1));
            ways.add(tmp);
        }
        int min = ways.get(ways.size() - 1)[1];
        for (Integer num :ways.get(ways.size() - 1))
            min = Math.min(min, num);
        return min;
    }
}