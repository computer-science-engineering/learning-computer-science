import os
import unittest
import traceback
import sys

def runTests():
    lsPaths = []
    cwd = os.getcwd()        

    #Find all relevant subdirectories that contain unit tests
    root_dir = "src"
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
      sys.path.remove(path)
      sys.modules.pop("test_solution")
      sys.modules.pop("solution")
      if len(testresult.failures) > 0 or len(testresult.errors) > 0:
          raise Exception()

def main():
    """main method."""
    try:              
        print("Running unit tests...")
        runTests()
        print("Finished running unit tests.")
    except Exception as e:
        sys.exit(f"Failure in unit test run. Exception: {e}.")

if __name__ == '__main__':
    main()