
import sys
sys.path.append('..')
import solution
import unittest

class TrivialCase(unittest.TestCase):
    def testTrivialCase1(self):
        """trivial case 1"""
        expected = (13, [2, 3, 23, 4, 1, 3, 13, 2, 5, 25, 9, 8, 2])
        actual = solution.find_strings(23413259802)
        self.assertEqual(expected, actual)

if __name__ == "__main__":
    unittest.main()