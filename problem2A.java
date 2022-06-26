class triangleMin {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        
        int m = triangle.size();
        
        
        //bottom up
        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}

//time complexity O(m * n) where m is rows and n is column
//space complexity O(1)