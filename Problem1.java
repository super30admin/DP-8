class Problem1 {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int count=0;
        int ans=0;
        
        
        for( int i=2;i<nums.length;i++){
            
            if(nums[i-1]-nums[i-2]==nums[i]-nums[i-1]){
                
                count++;
            ans+=count;
            }else{
                
                count=0;
            }
            
        }
        return ans;
        
        
    }
}