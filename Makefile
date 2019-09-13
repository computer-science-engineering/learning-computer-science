workspaceFolder := "./"

#*****************
# Java code tasks
#*****************

javabuild:
	./gradlew build

javatest:
	./gradlew test

javaclean:
	./gradlew clean

javatestcoverage:
	./gradlew test jacocoJupTestReport

javacode: javaclean javatestcoverage

#*****************
# C# code tasks
#*****************

xunittests:
	python ${workspaceFolder}/scripts/run_xunit_tests.py

csharpcode: xunittests

#*******************
# Python code tasks
#*******************

pythonrequirements:
	pip install -r requirements.txt

pythontests:
	python ${workspaceFolder}/scripts/run_unit_tests.py

pythontestcoverage:
	coverage3 run ${workspaceFolder}/scripts/run_unit_tests.py

pythoncode: pythontestcoverage

#*****************
# Project tasks
#*****************

createproblemslist:
	python ${workspaceFolder}/scripts/create_problems_list.py

#*****************
# All tasks
#*****************

all: createproblemslist javacode pythoncode csharpcode

