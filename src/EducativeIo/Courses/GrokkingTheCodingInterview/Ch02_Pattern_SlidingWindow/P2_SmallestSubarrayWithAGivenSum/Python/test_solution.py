# Copyright (c) 2021 Manas Talukdar
# 
# This software is released under the MIT License.
# https://opensource.org/licenses/MIT

import solution
import unittest

class TrivialCase(unittest.TestCase):
    def test_trivial_case_1(self):
        """"trivial case 1"""
        expected = 2
        sol = solution.Solution()
        actual = sol.smallest_subarray_with_given_sum(7, [2, 1, 5, 2, 3, 2])
        self.assertEqual(expected, actual)
    
    def test_trivial_case_2(self):
        """"trivial case 2"""
        expected = 1
        sol = solution.Solution()
        actual = sol.smallest_subarray_with_given_sum(7, [2, 1, 5, 2, 8])
        self.assertEqual(expected, actual)
   
    def test_trivial_case_3(self):
        """"trivial case 3"""
        expected = 3
        sol = solution.Solution()
        actual = sol.smallest_subarray_with_given_sum(8, [3, 4, 1, 1, 6])
        self.assertEqual(expected, actual)

if __name__ == "__main__":
    unittest.main()