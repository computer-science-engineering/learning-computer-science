class Solution:
    def equal(self, A):
        sums = {}
        for i in range(len(A) - 1):
            for j in range(i + 1, len(A)):
                val = A[i] + A[j]
                if val in sums:
                    add = True
                    for sum in sums[val]:
                        if sum[0] == i or sum[0] == j or sum[1] == i or sum[1] == j:
                            add = False
                    if add:
                        sums[val].append([i, j])
                else:
                    sums[val] = [[i, j]]

        equals = []
        for sum in sums:
            if len(sums[sum]) > 1:
                equals.append([sums[sum][0][0], sums[sum][0][1], sums[sum][1][0], sums[sum][1][1]])

        equals.sort()

        return equals[0] if equals else []
        
def main():
    solution = Solution()
    print(solution.equal([3, 4, 7, 1, 2, 9, 8]))

if __name__ == '__main__':
    main()