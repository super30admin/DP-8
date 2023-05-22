class Solution:
    # using bottom-up, take slice of 3 elements and if it follows the rules, then set dp[i]=dp[i]+1
    #TC-O(n),SC-O(n)
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        count=[0 for i in range(len(nums))]
        n=len(nums)
        total=0
        for i in range(n-3,-1,-1):
            if nums[i+2]-nums[i+1]==nums[i+1]-nums[i]:
                count[i]=count[i+1]+1
            total+=count[i]
        print(count)
        return total
            