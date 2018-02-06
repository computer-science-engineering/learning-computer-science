#!/usr/bin/env python
# -*- coding: utf-8 -*-

# https://github.com/kennethreitz/setup.py/blob/master/setup.py

# Note: To use the 'upload' functionality of this file, you must:
#   $ pip install twine

import io
import os
import sys
from shutil import rmtree

from setuptools import find_packages, setup, Command

# Package meta-data.
NAME = 'learning-computer-science'
DESCRIPTION = 'Learning data structures, algorithms, machine learning and various computer science constructs by programming practice from resources around the web.'
URL = 'https://github.com/manastalukdar/learning_computer-science'
EMAIL = ''
AUTHOR = 'Manas Talukdar'

# What packages are required for this module to be executed?
REQUIRED = [
    'markdown', 'BeautifulSoup4', 'coverage',
]