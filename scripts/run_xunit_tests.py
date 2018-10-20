import os
import unittest
import traceback
import sys
import re
from subprocess import call

def runTests():
    lsPaths = []
    cwd = os.getcwd()        

    #Find all relevant subdirectories that contain unit tests
    root_dir = "src"
    for root, dirs, files in os.walk(root_dir):
        dirs.sort()
        for file in files:
            if file == "SolutionTest.csproj":
                test_folder = os.path.join(cwd, root)
                lsPaths.append(test_folder)    

    #loop through subdirectories and run individually
    for path in lsPaths:
        os.chdir(path)
        call(["dotnet", "test"])

def main():
    """main method."""
    try:              
        print("Running xunit tests...")
        runTests()
        print("Finished running xunit tests.")
    except Exception as e:
        sys.exit(f"Failure in xunit test run. Exception: {e}.")

if __name__ == '__main__':
    main()