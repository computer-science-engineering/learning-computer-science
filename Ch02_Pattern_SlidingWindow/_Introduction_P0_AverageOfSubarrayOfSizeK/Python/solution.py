class Solution:
    def find_averages(self, k, arr):
        result = []
        window_sum = 0
        window_start = 0
        for window_end in range(len(arr)):
            window_sum += arr[window_end]
            if window_end >= k - 1:
                result.append(window_sum / k)
                window_sum -= arr[window_start]
                window_start += 1
        return result


def main():
    solution = Solution()
    print(solution.find_averages(5, [1, 3, 2, 6, -1, 4, 1, 8, 2]))


if __name__ == '__main__':
    main()