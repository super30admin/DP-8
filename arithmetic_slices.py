# get all the different arrays which are AP
# Use math to get the number of subarray for a given n and add it to total
# n * n+1 // 2 - subarrays for a given n - minus n (for size 1 subarray) - minus n-1(for subarray size 2 ) - (n-1) =
# (n * n + 1 // 2) - 2n + 1

def numberOfArithmeticSlices(nums):
    if len(nums) < 3:
        return 0
    diff = nums[1] - nums[0]
    # for i in range(2,len(nums)) :
    count = 2
    total = 0
    i = 2

    while i < len(nums):

        if nums[i] - nums[i - 1] == diff:

            while (i < len(nums) and nums[i] - nums[i - 1] == diff):
                count += 1
                i += 1

            if count >= 3:
                total += ((count * (count + 1)) // 2) - 2 * count + 1
                count = 1
        else:
            count = 1
            diff = nums[i] - nums[i - 1]

    return total


def main():
    nums = [1,2,3,4]
    print(numberOfArithmeticSlices(nums))


if __name__ == '__main__':
    main()
