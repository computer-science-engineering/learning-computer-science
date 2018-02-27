import solution
import unittest

class TrivialCase(unittest.TestCase):
    def testTrivialCase1(self):
        """"trivial case 1"""
        expected = "BANC"
        sol = solution.Solution()
        actual = sol.minWindow("ADOBECODEBANC", "ABC")
        self.assertEqual(expected, actual)

if __name__ == "__main__":
    unittest.main()