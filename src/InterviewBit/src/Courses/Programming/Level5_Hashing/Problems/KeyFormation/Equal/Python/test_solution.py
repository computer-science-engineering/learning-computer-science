import solution
import unittest

class TrivialCase(unittest.TestCase):
    def testTrivialCase1(self):
        """"trivial case 1"""
        expected = [0, 2, 3, 5]
        sol = solution.Solution()
        actual = sol.equal([3, 4, 7, 1, 2, 9, 8])
        self.assertEqual(expected, actual)
    
    def testSpecialCase1(self):
        """"trivial case 1"""
        expected = [0, 1, 2, 3]
        sol = solution.Solution()
        actual = sol.equal([1, 1, 1, 1, 1])
        self.assertEqual(expected, actual)

if __name__ == "__main__":
    unittest.main()