class Solution {

    //Approach: Top down DP using memoization
    //Time complexity: O(n * n) where n is the number of rows in the triangle list (n = triangle.size())
    //Space complexity: O(n * n)
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int numberOfRows = triangle.size();
        int[][] cache = new int[numberOfRows + 1][numberOfRows + 1];
        for(int[] row : cache){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return calculateMinTotalMem(0, 0, triangle, cache);

    }


    private int calculateMinTotalMem(int rowIdx, int colIdx, List<List<Integer>> triangle, int[][] cache){
        //base case
        if(rowIdx == triangle.size() - 1){
            cache[rowIdx][colIdx] = triangle.get(rowIdx).get(colIdx);
            return cache[rowIdx][colIdx];

        }

        if(cache[rowIdx][colIdx] != Integer.MAX_VALUE){
            return cache[rowIdx][colIdx];
        }

        int caseJustBelow = calculateMinTotalMem(rowIdx + 1, colIdx, triangle, cache);
        int caseNextBelow = calculateMinTotalMem(rowIdx + 1, colIdx +1, triangle, cache);

        int currentRowMin = Math.min(caseJustBelow, caseNextBelow);
        cache[rowIdx][colIdx] =  triangle.get(rowIdx).get(colIdx) + currentRowMin;
        return cache[rowIdx][colIdx];
    }


    //Approach: Bottom up DP using tabulation
    //Time complexity: O(n * n) where n is the number of rows in the triangle list (n = triangle.size())
    //Space complexity: O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        //return calculateMinTotalBruteForce(0, 0, 0, triangle);
        int numberOfRows = triangle.size();

        List<Integer> dp = new ArrayList<>();
        int lastRowSize = triangle.get(numberOfRows-1).size();
        for(int i = 0; i < lastRowSize; i++){
            dp.add(triangle.get(numberOfRows -1).get(i));
        }

        for(int i = triangle.size() - 2; i >= 0; i--){
            int currentRowSize = triangle.get(i).size();
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < currentRowSize ; j++){
                int currentValue = triangle.get(i).get(j);
                int min = Math.min(dp.get(j), dp.get(j+1));
                temp.add(currentValue + min);
            }
            dp = temp;
        }
        return dp.get(0);
    }

    //Approach: Recursive Brute Force solution
    //Time complexity: O(2 ^ n) where n is the number of rows in the triangle list (n = triangle.size())
    //Space complexity: O(n)
     private int calculateMinTotalBruteForce(int rowIdx, int colIdx, int pathSum, List<List<Integer>> triangle){
         //base case
         if(rowIdx == triangle.size()){
             return pathSum;
         }

         pathSum += triangle.get(rowIdx).get(colIdx);

         int caseJustBelow = calculateMinTotal(rowIdx + 1, colIdx, pathSum, triangle);
         int caseNextBelow = calculateMinTotal(rowIdx + 1, colIdx +1, pathSum, triangle);

         int currentRowMin = Math.min(caseJustBelow, caseNextBelow);
         return currentRowMin;
     }
}