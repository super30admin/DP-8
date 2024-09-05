

# self - similar to paint house problem
# create a dp matrix of same size - and fill the last row same as triangle matrix
# Just take min between next rows same col and next rows col+1 - keep filling matrix

def minimumTotal(triangle):

    dp = []
    for i in range(len(triangle)):
        new_list = []
        for j in range(len(triangle[i])):

            if i == len(triangle) - 1:
                new_list.append(triangle[i][j])
            else:
                new_list.append(0)

        dp.append(new_list)

    i = len(triangle) - 2

    while (i >= 0):
        j = 0
        while (j < len(triangle[i])):
            dp[i][j] = triangle[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1])

            j += 1

        i -= 1

    return dp[0][0]



def main():

    # print(minimumTotal([[2],[3,4],[6,5,7],[4,1,8,3]]))
    print(minimumTotal([[-1], [2, 3], [1, -1, -3]]))

if __name__ == '__main__':
    main()
