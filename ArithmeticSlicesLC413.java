class Solution {

    //Apparoch 7
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    public int numberOfArithmeticSlices(int[] nums) {

        if(nums == null || nums.length == 0) return 0;                              //check for null case

        int count = 0;                                                              //to store the result
        int prev = 0;                                                               //store the prev value(it basically store the number of arithmatic slices possible from the prev index)
        int current = 0;                                                            //store the current value(it basically store the number of arithmatic slices possible from the current index)

        for(int i=2; i<nums.length; i++){                                           //iterate through nums array

            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){                       //check if both difference nums[i]-nums[i-1] and nums[i-1] -nums[i-2] are equal or not 

                current = prev + 1;                                                 //if its equal, then get the current value by taking prev+1
                count = count + current;                                            //add current value to the count
            }
            else{
                current = 0;                                                        //if both difference are not equal, then update the current value by 0 as from that index, no arithmatic slice possible
            }
            prev = current;                                                         //update the prev value( which will be useful for the next element)
        }
        return count;                                                               //return the count
    }




    //Apparoch 6
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    // public int numberOfArithmeticSlices(int[] nums) {

    //     if(nums == null || nums.length == 0) return 0;

    //     int count = 0;
    //     int next = 0;
    //     int current = 0;

    //     for(int i=nums.length-3; i>=0; i--){

    //         if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){

    //             current = next + 1;
    //             count = count + current;
    //         }
    //         else{
    //             current = 0;
    //         }
    //         next = current;
    //     }
    //     return count;
    // }




     //Apparoch 5
    //Time Complexity: O(n)
    //Space Complexity: O(n)

    // public int numberOfArithmeticSlices(int[] nums) {

    //     if(nums == null || nums.length == 0) return 0;

    //     int[] dp = new int[nums.length];
    //     int count = 0;

    //     for(int i=nums.length-3; i>=0; i--){

    //         if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){
    //             dp[i] = dp[i+1] + 1;
    //             count = count + dp[i];
    //         }
    //     }
    //     return count;
    // }



    
    //Apparoch 4
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    
    // public int numberOfArithmeticSlices(int[] nums) {

    //     if(nums == null || nums.length == 0) return 0;

    //     int[] dp = new int[nums.length];
    //     int count = 0;

    //     for(int i=2; i<nums.length; i++){

    //         if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
    //             dp[i] = dp[i-1] + 1;
    //             count = count + dp[i];
    //         }
    //     }
    //     return count;
    // }



    
    //Approach 3, recursive approach
    //Time Complexity: O(n)
    //Space Complexity: O(n) //recursive stack space

    // public int numberOfArithmeticSlices(int[] nums) {
    
    //     return numberOfArithmeticSlices(nums, 0, 0, 0);
        
    // }
    
    // public int numberOfArithmeticSlices(int[] nums, int currentIndex, int prev, int ans){
        
    //     if(currentIndex == nums.length){
    //         return ans;
    //     }
        
    //     if(currentIndex > 1){
    //         int diff1 = nums[currentIndex] - nums[currentIndex-1];
    //         int diff2 = nums[currentIndex-1] - nums[currentIndex-2];

    //         if(diff1 == diff2){
    //             return numberOfArithmeticSlices(nums, currentIndex+1, prev+1, ans+prev+1);
    //         }
    //     }
    //     return numberOfArithmeticSlices(nums, currentIndex+1, 0, ans);
    // }
    
    
    
    
    
    //Approach 2, iterative approach
    //Time Complexity: O(n)
    //Space Complexity: O(1)

//     public int numberOfArithmeticSlices(int[] nums) {
    
//         int ans = 0;
//         int prev = 0;

//         for(int i=2; i<nums.length; i++){
            
//             int diff1 = nums[i] - nums[i-1];
//             int diff2 = nums[i-1] - nums[i-2];
            
//             if(diff1 == diff2){
//                 int current = prev + 1;
//                 ans += current;
//                 prev = current;
//             }
//             else{
//                 prev = 0;
//             }
//         }
//         return ans;
//     }
    
    


    //Approach 1
    //Time Complexity: O(n*n)
    //Space Complexity: O(1)

//     public int numberOfArithmeticSlices(int[] nums) {
        
//         int count =0;
        
//         for(int i=0; i<nums.length-2; i++){
            
//             int diff = nums[i+1] - nums[i];
            
//             for(int j = i+2; j<nums.length; j++){
                
//                 int currentDiff = nums[j] - nums[j-1];
                
//                 if(currentDiff == diff){
//                     count++;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
}
