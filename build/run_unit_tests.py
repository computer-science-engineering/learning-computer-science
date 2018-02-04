import os
import unittest
import traceback
import sys


def runTests():
    lsPaths = []

    #Find all relevant subdirectories that contain unit tests
    root_dir = "src"    
    cwd = os.getcwd()
    for root, dirs, files in os.walk(root_dir):
        dirs.sort()
        for file in files:
            if "pycache" not in root and file.startswith("test_"):
                test_folder = os.path.join(cwd, root)
                lsPaths.append(test_folder)

    #loop through subdirectories and run individually
    for path in lsPaths:
      sys.path.append(path)
      loader = unittest.TestLoader()
      suite = unittest.TestSuite()
      suite = loader.discover(path)
      testresult = unittest.TextTestRunner().run(suite)
      if len(testresult.failures) > 0 or len(testresult.errors) > 0:
          raise Exception()

def main():
    """main method."""
    try:        
        print("Running unit tests...")
        runTests()
        print("Finished running unit tests.")
    except Exception:
        sys.exit("Failure in unit test run.")

if __name__ == '__main__':
    main()