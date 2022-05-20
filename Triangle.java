public class Triangle {
  /**
    Without Mutating the input Triangle
    
    Using auxilary extra O(n) space.
    
    Bottom - Up
    
    Time Complexity: O(m*n)
      m* n -> representing the triangle size.
      
    Space Complexity: O(n)
    
    Were you able to solve this on leetcode? Yes
    */
    public int minimumTotal(List<List<Integer>> triangle)  {
      int n = triangle.size();
      
      int[] list = new int[n]; // this is the max list size we need. 
      
      // fill the list with the last row in triangle
      for(int i = 0; i < triangle.size(); i++){
          list[i] = triangle.get(n-1).get(i);
      }
      
      for(int i = n-2 ; i >= 0; i--) {
          for(int j = 0; j <= i; j++) {
              list[j] = triangle.get(i).get(j) + Math.min(list[j] , list[j+1]);
          }
      }
      
      return list[0];
  }
  
  /**
   Top - Down
  
  Mutating the Triangle itself.
  
  Time Complexity: O(m * n)
  Space Complexity: O(1)
  */
  public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      for(int i = 1; i < n; i++){
          for(int j = 0; j <= i; j++){
              if(j == 0){
                  triangle.get(i).set(
                      j,
                      triangle.get(i).get(j) + triangle.get(i-1).get(j)
                  );
              } else if(j == i){
                  triangle.get(i).set(
                      j,
                      triangle.get(i).get(j) + triangle.get(i-1).get(j-1)
                  );
              } else {
                  triangle.get(i).set(
                      j,
                      triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j))
                  );
              }
          }
      }
      
      int result = Collections.min(triangle.get(n-1));
      
      return result;
  }
  
  /**
   Bottom - Up
  
  Mutating the input Triangle itself.
  
  Time Complexity: O(m * n)
  Space Complexity: O(1)
  
  */
  public int minimumTotal(List<List<Integer>> triangle) {
      
      int n = triangle.size();
      for(int i = n - 2; i >= 0; i--){
          for(int j = 0; j <= i ; j++){
              triangle.get(i).set(
                  j,
                  triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1))
              );
          }
      }
      
      return triangle.get(0).get(0);
  }
}
