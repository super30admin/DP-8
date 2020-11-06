// TC: O(area of triangle)
// SC: O(n)

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int n = 0;
        // int i = 0;
        // List<Integer> list = triangle.get(0);
        // int sum = Integer.MAX_VALUE;
        // int index = -1;
        // for(int j=0; j<list.size(); j++){
        //     if(list.get(i) < sum){
        //         sum = list.get(j);
        //         index = j;
        //     }
        // }
        // System.out.println(index+" "+sum);
        // int x = 0, y = 0;
        // while(n < triangle.size()){
        //     if(index )
        // }
        
        if(triangle==null) {
            return 0;
        }
        
        int n = triangle.size();
        int[] arr = new int[n];
        
        // getting the base layer of the triangle and moving upwards
        for(int i=0; i<n; i++){
            arr[i] = triangle.get(n-1).get(i);
        }
        
        for(int i=n-2; i>=0; i--) {
            // getting the layers of the triangle
            List<Integer> list = triangle.get(i);
            for(int j=0; j<list.size(); j++) {
                // getting min of first 2 elements and adding to the first element of the array
                arr[j] = Math.min(arr[j], arr[j+1]) + list.get(j);
            }
        }
        
        // by the approach we will have the minimum as the first index
        return arr[0];
    }    
    
}
