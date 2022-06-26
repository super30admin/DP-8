class triangleMin {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        
        int m = triangle.size();
        
        
        int result = Integer.MAX_VALUE;
        //up to down
        for(int i = 1; i < m; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i -1).get(j));
                }
                else if(j == i){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i -1).get(j - 1));
                }
                else{
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            result = Math.min(result, triangle.get(m - 1).get(i));
        }
        return result;
    }
}

//time complexity O(m * n) where m is rows and n is column
//space complexity O(1)