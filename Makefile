workspaceFolder :=
gradlewScript :=

# https://gist.github.com/sighingnow/deee806603ec9274fd47
ifneq ($(OS),Windows_NT)
	workspaceFolder = ./
	gradlewScript = gradlew
else
	gradlewScript = .\gradlew.bat
endif

#*****************
# Java code tasks
#*****************

java-dependencies:
	${workspaceFolder}${gradlewScript} dependencies

java-build:
	${workspaceFolder}${gradlewScript} build

java-test:
	${workspaceFolder}${gradlewScript} test

java-clean:
	${workspaceFolder}${gradlewScript} clean

java-test-coverage:
	${workspaceFolder}${gradlewScript} test jacocoJupTestReport

java-code: java-dependencies java-clean java-test-coverage

#*****************
# C# code tasks
#*****************

csharp-xunit-tests:
	python ${workspaceFolder}scripts/run_xunit_tests.py

csharp-code: csharp-xunit-tests

#*******************
# Python code tasks
#*******************

python-requirements:
	pip install -r requirements.txt

python-tests:
	python ${workspaceFolder}scripts/run_unit_tests.py

python-test-coverage:
	coverage run ${workspaceFolder}scripts/run_unit_tests.py

python-code: python-test-coverage

#*****************
# Project tasks
#*****************

get-problems-count:
	python ${workspaceFolder}scripts/get_problems_count.py

#*****************
# Git tasks
#*****************

git-version:
	git --version

git-submodules-setup:
	git submodule sync --recursive
	git submodule foreach --recursive git fetch
	git submodule foreach git pull

git-get-submodules:
	git submodule update --init --recursive --remote
	#git submodule update --init --recursive --remote --merge

#*****************
# All tasks
#*****************

git: git-version git-submodules-setup git-get-submodules

code: java-code python-code csharp-code

all: git get-problems-count code

