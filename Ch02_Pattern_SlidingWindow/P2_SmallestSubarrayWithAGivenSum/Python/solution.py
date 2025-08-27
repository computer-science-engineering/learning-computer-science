# Copyright (c) 2021 Manas Talukdar
# 
# This software is released under the MIT License.
# https://opensource.org/licenses/MIT

import math

class Solution:
  def smallest_subarray_with_given_sum(self, s, arr):
    window_sum = 0
    min_length = math.inf
    window_start = 0

    for window_end in range(0, len(arr)):
      window_sum += arr[window_end]  # add the next element
      # shrink the window as small as possible until the 'window_sum' is smaller than 's'
      while window_sum >= s:
        min_length = min(min_length, window_end - window_start + 1)
        window_sum -= arr[window_start]
        window_start += 1
    if min_length == math.inf:
      return 0
    return min_length
    
def main():
  solution = Solution()
  print(solution.smallest_subarray_with_given_sum(7, [2, 1, 5, 2, 3, 2]))
  print(solution.smallest_subarray_with_given_sum(7, [2, 1, 5, 2, 8]))
  print(solution.smallest_subarray_with_given_sum(8, [3, 4, 1, 1, 6]))

if __name__ == '__main__':
  main()