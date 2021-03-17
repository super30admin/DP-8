#Time: O( N * N)
#Space: O(1)

for r in range(1, len(tri)):
            for c in range(len(tri[r])):
                prv_a = tri[r-1][c-1] if c-1 >= 0 else float("inf")
                prv_b = tri[r-1][c] if c < len(tri[r-1]) else float("inf")

                tri[r][c] += min(prv_a, prv_b)
        return min(tri[-1])