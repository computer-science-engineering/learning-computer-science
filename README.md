# Learning Computer Science

![logo](https://github.com/manastalukdar/learning-computer-science/blob/master/resources/images/logo/Logo%20LCS%20color/logo%20LCS%20color%20low%20res.png?raw=true)

1. [Learning Computer Science](#learning-computer-science)
   1. [Overview](#overview)
      1. [Metadata](#metadata)
      2. [Continuous Integration](#continuous-integration)
   2. [Usage](#usage)
      1. [Viewing](#viewing)
   3. [Development](#development)
      1. [Environment](#environment)
      2. [Running Tests](#running-tests)
      3. [CI, CD](#ci-cd)
      4. [Upgrading to newer versions of development environments](#upgrading-to-newer-versions-of-development-environments)
         1. [Java](#java)
         2. [Gradle](#gradle)
         3. [Python](#python)
      5. [Contributing](#contributing)
      6. [Other](#other)
   4. [Project Management](#project-management)
   5. [Links](#links)
   6. [Note](#note)
   7. [References](#references)
   8. [License](#license)

## Overview

Learning data structures, algorithms, machine learning and various computer science constructs by programming practice from resources around the web.

### Metadata

| Provider                                                                                         | Data                                      | Status                                                                                                                                                                                                                                                                                                                                                                              |
| ------------------------------------------------------------------------------------------------ | ----------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Discord                                                                                          | Chat Server                               | ![Discord](https://img.shields.io/discord/611637065913729036)                                                                                                                                                                                                                                                                                                                       |
| GitHub                                                                                           | Repo Size                                 | ![GitHub repo size](https://img.shields.io/github/repo-size/manastalukdar/learning-computer-science)                                                                                                                                                                                                                                                                                |
| GitHub                                                                                           | Code Size                                 | ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/manastalukdar/learning-computer-science)                                                                                                                                                                                                                                                             |
| GitHub                                                                                           | Commit Activity                           | ![GitHub commit activity](https://img.shields.io/github/commit-activity/m/manastalukdar/learning-computer-science)                                                                                                                                                                                                                                                                  |
| GitHub                                                                                           | Last Commit                               | ![GitHub last commit (branch)](https://img.shields.io/github/last-commit/manastalukdar/learning-computer-science/master)                                                                                                                                                                                                                                                            |
| GitHub                                                                                           | Open Issues                               | ![GitHub issues](https://img.shields.io/github/issues-raw/manastalukdar/learning-computer-science)                                                                                                                                                                                                                                                                                  |
| GitHub                                                                                           | Closed Issues                             | ![GitHub issues](https://img.shields.io/github/issues-closed/manastalukdar/learning-computer-science)                                                                                                                                                                                                                                                                               |
| GitHub                                                                                           | Language Count                            | ![GitHub language count](https://img.shields.io/github/languages/count/manastalukdar/learning-computer-science)                                                                                                                                                                                                                                                                     |
| GitHub                                                                                           | License                                   | ![GitHub](https://img.shields.io/github/license/manastalukdar/learning-computer-science)                                                                                                                                                                                                                                                                                            |
| [FOSSA](https://fossa.com/)                                                                      | Open Source Software Management           | [![FOSSA Status](https://app.fossa.com/api/projects/custom%2B10734%2Fgit%40github.com%3Amanastalukdar%2Flearning-computer-science.git.svg?type=shield)](https://app.fossa.com/projects/custom%2B10734%2Fgit%40github.com%3Amanastalukdar%2Flearning-computer-science.git?ref=badge_shield) [work-in-progress](https://github.com/manastalukdar/learning-computer-science/issues/53) |
| [CII Best Practices](https://bestpractices.coreinfrastructure.org/en)                            | Open source software best practices check | [![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/1761/badge)](https://bestpractices.coreinfrastructure.org/projects/1761)                                                                                                                                                                                                                               |
| [david-dm](https://david-dm.org/manastalukdar/learning-computer-science?path=website-react-next) | Check node.js dependency status           | ![David (path)](https://img.shields.io/david/manastalukdar/learning-computer-science?path=website-react-next)                                                                                                                                                                                                                                                                       |
| david-dm                                                                                         | Check node.js dev dependency status       | ![David (path)](https://img.shields.io/david/manastalukdar/learning-computer-science?path=website-react-next&type=dev)                                                                                                                                                                                                                                                              |

### Continuous Integration

| Platform       | Provider    | Operations                              | Status                                                                                                                                                                                                                                                                                                |
| -------------- | ----------- | --------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Windows, Linux | AppVeyor    | Build, Test                             | [![Build status](https://ci.appveyor.com/api/projects/status/y9qup8owf4e53m8h?svg=true)](https://ci.appveyor.com/project/manastalukdar/learning-computer-science)                                                                                                                                     |
| Linux          | Travis CI   | Build, Test, Deploy to gh-pages         | [![Build Status](https://travis-ci.org/manastalukdar/learning-computer-science.svg?branch=master)](https://travis-ci.org/manastalukdar/learning-computer-science)                                                                                                                                     |
| Linux          | Circle CI   | Build, Test                             | [![CircleCI](https://circleci.com/gh/manastalukdar/learning-computer-science/tree/master.svg?style=svg)](https://circleci.com/gh/manastalukdar/learning-computer-science/tree/master)                                                                                                                 |
| N/A            | CodeClimate | Check for code maintainability          | [![Maintainability](https://api.codeclimate.com/v1/badges/2ece575493d263e8b83c/maintainability)](https://codeclimate.com/github/manastalukdar/learning-computer-science/maintainability)                                                                                                              |
| N/A            | CodeClimate | Check for test coverage using Circle CI | [![Test Coverage](https://api.codeclimate.com/v1/badges/2ece575493d263e8b83c/test_coverage)](https://codeclimate.com/github/manastalukdar/learning-computer-science/test_coverage)                                                                                                                    |
| N/A            | Codacy      | Code analysis/quality check             | [![Codacy Badge](https://api.codacy.com/project/badge/Grade/93f9326796aa44a3a9eac1fe9c13cc24)](https://www.codacy.com/app/manastalukdar/learning-computer-science?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=manastalukdar/learning-computer-science&amp;utm_campaign=Badge_Grade) |
| N/A            | CodeBeat    | Static code analysis                    | [![codebeat badge](https://codebeat.co/badges/882b6622-7bc2-4923-97b2-a053057d3a45)](https://codebeat.co/projects/github-com-manastalukdar-learning-computer-science-master)                                                                                                                          |
| N/A            | Codecov     | Code coverage using Circle CI           | [![codecov](https://codecov.io/gh/manastalukdar/learning-computer-science/branch/master/graph/badge.svg)](https://codecov.io/gh/manastalukdar/learning-computer-science)                                                                                                                              |
| N/A            | Coveralls   | Code coverage using Circle CI           | [![Coverage Status](https://coveralls.io/repos/github/manastalukdar/learning-computer-science/badge.svg?branch=master)](https://coveralls.io/github/manastalukdar/learning-computer-science?branch=master) [Known issue](https://github.com/manastalukdar/learning-computer-science/issues/35)        |

## Usage

### Viewing

1. Open repository using [Visual Studio Code](https://code.visualstudio.com/). Recommended extensions have been provided by the repository (.vscode folder).
2. Use [Sourcegraph](https://sourcegraph.com/github.com/manastalukdar/learning-computer-science/).
3. A website for filtering and querying is [work-in-progress](https://github.com/manastalukdar/learning-computer-science/projects/1).

## Development

### Environment

Highly recommended to open/use this repository using [Visual Studio Code](https://code.visualstudio.com/).

| Language | Version | Package                                                                    |
| -------- | ------- | -------------------------------------------------------------------------- |
| Java     | 12      | OpenJDK ([AdoptOpenJDK with HotSpot](https://adoptopenjdk.net/index.html)) |
| Python   | 3.7.2   | N/A                                                                        |

### Running Tests

1. VSCode tasks are available via the repository (.vscode folder) for running all language specific tests. Please familiarize yourself with using tasks in VSCode.

### CI, CD

Repository is connected to multiple CI, CD providers.

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

### Contributing

1. Please follow the template for adding problems. This is inherently tied into the mechanism for searching through problems using the [planned website](https://github.com/manastalukdar/learning-computer-science/projects/1).
2. Templates for metadata.json (problem metadata), readme.md (problem definition) and language specific solution and solution test files are available via VSCode snippets. They are all committed and available via the repository (.vscode folder). Please familiarize yourself with using snippets in VSCode.
3. You are encouraged to fork this repository and submit pull requests.

### Other

1. For those who may not wish to use VSCode and instead prefer a simple text editor
    1. I plan to create a [makefile](https://github.com/manastalukdar/learning-computer-science/issues/50).
    1. Instructions will be provided at a later time for command line usage to add new problems, run tests, etc. [[Ref](https://github.com/manastalukdar/learning-computer-science/issues/51)]
1. I do not recommend using any sort of bloated IDE. They tend to add a lot of files simply for their specific plumbing.

## Project Management

[GitHub Projects](https://github.com/manastalukdar/learning-computer-science/projects)

## Links

- [Sourcegraph](https://sourcegraph.com/github.com/manastalukdar/learning-computer-science/)
- [Discord Server](https://discord.gg/bv5FU8t)

## Note

1. Problems in the repository are not necessarily solved by me. The goal is to learn. Sometimes in the interest of time, that involves understanding an existing solution rather than spending an inordinate amount of time trying to solve it by myself. Where applicable I have provided references to the original solution.
2. Problems in this repository are not unique. Given that the same (or similar) problem may exist in multiple origins, more than a few problems are repeated. It is my goal to provide some sort of querying mechanism via a [website](https://github.com/manastalukdar/learning-computer-science/projects/1) for users to view only a unique instance of a problem, either from a "first or default" origin or a specified origin.

## References

N/A

## License

[MIT](https://github.com/manastalukdar/learning-computer-science/blob/master/LICENSE)
