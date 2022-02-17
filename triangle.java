class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0; //if the triangle is null or the size of the triangle is 0, we return 0
        int n = triangle.size(); //n has the size of the triangle

        for(int i = 1; i < n; i++) { //we start going through the list starting from top and 1 index
            for(int j = 0; j <= i; j++) { //we go through all the elements in the list of integers
                if(j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                }
                else if(j == i) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                }
                else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
        }
        int min = Integer.MAX_VALUE; //to get the min, we set the min to max value
        for(int j = 0; j < n; j++) { //we go through the elements in the last list of integers
            min = Math.min(min, triangle.get(n - 1).get(j)); //we compute the min
        }
        return min; //in the end, we return the min
    }
}
//tc and sc - O(m * n) and O(1)