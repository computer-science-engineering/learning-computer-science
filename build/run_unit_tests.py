import os
import unittest
import traceback


def runTests():
    print("Running unit tests...")

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
      loader = unittest.TestLoader()
      suite = unittest.TestSuite()
      suite = loader.discover(path)
      unittest.TextTestRunner().run(suite)

    
    print("Finished running unit tests.")

def main():
    """main method."""
    runTests()

if __name__ == '__main__':
    main()