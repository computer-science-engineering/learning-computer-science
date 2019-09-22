# Testing

1. VSCode tasks are available via the repository (.vscode folder) for running all language specific tests. Please familiarize yourself with using tasks in VSCode.
2. Makefile tasks are also provided for running tests.
3. To run individual test using gradlew following example may be used as a guideline: `./gradlew test --tests *P1_FindTheMedianOfANumberStream*`. If during test tun, print outputs needs to be viewed, uncomment line `showStandardStreams true` in the build.gradle file at the root of the project.
