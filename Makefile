workspaceFolder := 
gradlewScript :=

# https://gist.github.com/sighingnow/deee806603ec9274fd47
ifneq ($(OS),Windows_NT)
	workspaceFolder += ./
	gradlewScript += gradlew
else
	gradlewScript += .\gradlew.bat
endif

#*****************
# Java code tasks
#*****************

javadependencies:
	${workspaceFolder}${gradlewScript} dependencies

javabuild:
	${workspaceFolder}${gradlewScript} build

javatest:
	${workspaceFolder}${gradlewScript} test

javaclean:
	${workspaceFolder}${gradlewScript} clean

javatestcoverage:
	${workspaceFolder}${gradlewScript} test jacocoJupTestReport

javacode: javadependencies javaclean javatestcoverage

#*****************
# C# code tasks
#*****************

xunittests:
	python ${workspaceFolder}scripts/run_xunit_tests.py

csharpcode: xunittests

#*******************
# Python code tasks
#*******************

pythonrequirements:
	pip install -r requirements.txt

pythontests:
	python ${workspaceFolder}scripts/run_unit_tests.py

pythontestcoverage:
	coverage run ${workspaceFolder}scripts/run_unit_tests.py

pythoncode: pythontestcoverage

#*****************
# Project tasks
#*****************

createproblemslist:
	python ${workspaceFolder}scripts/create_problems_list.py

#*****************
# All tasks
#*****************

all: createproblemslist javacode pythoncode csharpcode

