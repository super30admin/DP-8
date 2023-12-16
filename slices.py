# Time: O(n)
# Space: O(1) or O(n) for dp array
# Did it run on Leetcode: yes

# at each index if the diff is same between the prev 2- then we have one slice, at next index we check if the diff is same- if yes we add 1 to the count of slices in prev ind
class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # BF- nested iterations - O(n^2)
        # n=len(nums)
        # count=0
        # if(n<3):
        #     return 0
        # for i in range(n-2):
        #     diff=nums[i+1]-nums[i]
        #     for j in range(i+2,n):
        #         if(diff==nums[j]-nums[j-1]):
        #             count+=1
        #         else:
        #             break
        # return count

        # DP O(n), O(n)-dp array, O(1)
        n=len(nums)
        count=0
        if(n<3):
            return 0
        # dp=[0]*(n)
        prev=0
        curr=0
        for  i in range(2,n):
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]):
                # dp[i]=dp[i-1]+1
                curr=prev+1
                count+=curr
            else:
                curr=0
            prev=curr
        return count
        