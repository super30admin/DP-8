class Solution {
  public int Triangle(List<List<Integer>> triangle) {
    int m = triangle.size();
    int n = triangle.get(m - 1).size();
    int[] sums = new int[n];
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        int smallest = Integer.MAX_VALUE;
        if (j == 0) {
          smallest = triangle.get(i - 1).get(j);
        } else if (j == triangle.get(i).size() - 1) {
          smallest = triangle.get(i - 1).get(j - 1);
        } else {
          smallest = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
        }
        triangle.get(i).set(j, smallest + triangle.get(i).get(j));
      }
    }
    return Collections.min(triangle.get(m - 1));
  }
}