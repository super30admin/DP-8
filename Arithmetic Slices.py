# Time complexity: O(n)
# Space complexity: O(1)
# Approach: Using dynamic programming
# start traversing i from index 2 to n
# check if the differences between the numbers from i-2 to i are same, if same,
# make curr as prev + 1
# since prev says if its fourth/ fifth consectuve number or so
# add the curr to count
# if the differences are not same, make the prev as 0 as the consecutive subarray rule is broken.


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        prev = 0
        curr = 0
        count = 0
        for i in range(2,len(nums)):
            if nums[i]-nums[i-1] == nums[i-1]-nums[i-2]:
                curr = prev + 1
                prev = curr
                count = count+ curr
            else:
                prev = 0
        return count
        