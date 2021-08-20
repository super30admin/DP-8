class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        """Using DP Approach Top Down - using variables for DP
        Time complexity-O(n)
        Space complexity-O(1)"""
        total=0
        curr=0
        for i in range(2, len(nums)):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                curr=curr+1
                total+=curr
            else:
                curr=0
        return total
        """Using DP Approach Top Down - Array
        Time complexity-O(n)
        Space complexity-O(n)"""
        # dparr=[0 for i in range(len(nums))]
        # total=0
        # for i in range(2, len(nums)):
        #     if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
        #         dparr[i]=dparr[i-1]+1
        #         total+=dparr[i]
        # return total
            
        """Using DP Approach Bottom UP - Array
        Time complexity-O(n)
        Space complexity-O(n)"""
        # dparr=[0 for i in range(len(nums))]
        # total=0
        # for i in range(len(nums)-3,-1, -1):
        #     if nums[i]-nums[i+1]==nums[i+1]-nums[i+2]:
        #         dparr[i]=dparr[i+1]+1
        #         total+=dparr[i]
        # return total
            
            
        """Bruteforce Approach-nested iterations
        Time complexity-O(n^2) where n is the length of nums
        Space complexity-O(1)"""
        # total=0
        # for i in range(len(nums)-2):
        #     diff=nums[i]-nums[i+1]
        #     for j in range(i+1, len(nums)-1):
        #         if nums[j]-nums[j+1]==diff:
        #             total+=1
        #         else:
        #             break
        # return total
        