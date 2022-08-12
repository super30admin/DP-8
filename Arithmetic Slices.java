class Solution {
  public int numberOfArithmeticSlices(int[] arr) {

    int ans = 0;

    int i = 0;
    while (i < arr.length - 1) {
      int v = arr[i] - arr[i + 1];
      int c = 0;
      while (i < arr.length - 1 && arr[i] - arr[i + 1] == v) {
        c++;
        i++;
      }
      if (c >= 2)
        ans += ((c - 1) * c) / 2;
    }
    return ans;

  }
}