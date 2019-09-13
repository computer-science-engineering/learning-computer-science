# Requirements

1. [Environment](#environment)
   1. [Upgrading to newer versions of development environments](#upgrading-to-newer-versions-of-development-environments)
      1. [Java](#java)
      2. [Gradle](#gradle)
      3. [Python](#python)
2. [Other](#other)

## Environment

| Language | Version | Package                                                                    |
| -------- | ------- | -------------------------------------------------------------------------- |
| Java     | 12      | OpenJDK ([AdoptOpenJDK with HotSpot](https://adoptopenjdk.net/index.html)) |
| Python   | 3.7.2   | N/A                                                                        |

I recommended using [VS Code](https://code.visualstudio.com/).

If you are on Windows, I highly recommend installing [msys2](http://www.msys2.org/). After installation, run the following from the `msys2` shell:

```plaintext
pacman -Syu
pacman -S base-devel
pacman -S mingw-w64-x86_64-toolchain
pacman -S mingw-w64-x86_64-cmake
```

### Upgrading to newer versions of development environments

#### Java

1. Install latest version of Java: OpenJDK (Red Hat for Windows).
1. On Windows, update the Path environment variable to point to new Java install location. Look out for JAVA_HOME env var, and javapath in the Path env var.
1. Update build.gradle script (`sourceCompatibility` and `targetCompatibility`).
1. Download and update the (latest) version of gradle compatible with the new version of Java.
1. In Windows, update the Path environment variable to point to new gradle install location.
1. In the repository root, from admin command prompt, run `gradle wrapper --gradle-version <new gradle version>`.
1. Make sure `distributionUrl` in `gradle/wrapper/gradle-wrapper.properties` points to new gradle version.
1. Delete .project and .classpath files.
1. Delete all contents of bin directory.
1. Close VSCode.
1. Clear [workspace cache](https://github.com/Microsoft/vscode-java-debug/blob/master/Troubleshooting.md#try).
1. Restart VSCode.
1. Make sure new .project and .classpath files have been generated. Verify that .classpath now points to the new version of Java. This may take a good few minutes.
1. Run gradlew test and code coverage tasks.
1. Update CI scripts (appveyor, circle-ci, travis) to point to new Java version.
   1. For circle-ci, docker image tags can be viewed [here](https://circleci.com/docs/2.0/docker-image-tags.json).

#### Gradle

From the project root, run `.\gradlew.bat wrapper --gradle-version x.x.x`. For Linux, run gradlew from the root, instead of the .bat file. Use the desired version in the command. Verify that the `distributionUrl` field in the file `gradle-wrapper.properties` has been updated to reflect the correct version. [[Reference](https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:upgrading_wrapper)]

#### Python

1. Install latest version of Python.
2. Run tasks for python tests, coverage reports and problems list.
3. Update CI scripts (appveyor, circle-ci, travis) to point to new Python version.

## Other

1. For those who may not wish to use VSCode and instead prefer a simple text editor
    1. There is a `Makefile` at the root of this repository for building and running tests.
    1. Instructions will be provided at a later time for command line usage to add new problems, run tests, etc. [[Ref](https://github.com/manastalukdar/learning-computer-science/issues/51)]
1. I do not recommend using any sort of bloated IDE. They tend to add a lot of files simply for their specific plumbing.
