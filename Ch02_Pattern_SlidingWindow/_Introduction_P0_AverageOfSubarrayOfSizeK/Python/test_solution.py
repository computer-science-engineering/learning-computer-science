import solution
import unittest


class TrivialCase(unittest.TestCase):
    def test_trivial_case_1(self):
        """"trivial case 1"""
        expected = [2.2, 2.8, 2.4, 3.6, 2.8]
        sol = solution.Solution()
        actual = sol.find_averages(5, [1, 3, 2, 6, -1, 4, 1, 8, 2])
        self.assertEqual(expected, actual)


if __name__ == "__main__":
    unittest.main()