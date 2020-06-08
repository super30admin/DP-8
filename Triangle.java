// 120.
// similar to paint house and minimum falling path sum
// time - O(n)
// space - O(1) - manipulating i/p triangle
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //edge
        if(triangle == null || triangle.size() == 0)
        {
            return 0;
        }
        
        for(int row = triangle.size() - 2; row >= 0; row--)
        {
            //start filling from second last row
            //last row remains same
            for(int i = 0; i < triangle.get(row).size(); i++)
            {
                //filling each row
                Integer caseOne = triangle.get(row).get(i) + triangle.get(row + 1).get(i); //same col next row
                Integer caseTwo = triangle.get(row).get(i) + triangle.get(row + 1).get(i + 1); //next col next row
                triangle.get(row).set(i, Math.min(caseOne, caseTwo));
            }
        }
        
        return triangle.get(0).get(0); //return element in top row 1st col
    }
}
