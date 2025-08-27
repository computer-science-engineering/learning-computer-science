# Copyright (c) 2021 Manas Talukdar
# 
# This software is released under the MIT License.
# https://opensource.org/licenses/MIT

import solution
import unittest

class TrivialCase(unittest.TestCase):
    def test_trivial_case_1(self):
        """"trivial case 1"""
        expected = 9
        sol = solution.Solution()
        actual = sol.max_sub_array_of_size_k(3, [2, 1, 5, 1, 3, 2])
        self.assertEqual(expected, actual)
    
    def test_trivial_case_2(self):
        """"trivial case 2"""
        expected = 7
        sol = solution.Solution()
        actual = sol.max_sub_array_of_size_k(2, [2, 3, 4, 1, 5])
        self.assertEqual(expected, actual)

if __name__ == "__main__":
    unittest.main()