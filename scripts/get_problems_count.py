"""
Script to get list of all problems by parsing readme.md from all subdirectories under ..\\src\\
pip install -r python-requirements.txt
"""

import os
import json


def find_files():
    """Return the list of files to process."""
    result = {}
    root_dir = "src"
    cwd = os.getcwd()
    #print(os.listdir(root_dir))
    for root, dirs, files in os.walk(root_dir):
        dirs.sort()
        for file in files:
            if file.endswith("metadata.json"):
                metadatafile = os.path.join(cwd, root, file)
                contents = open(metadatafile)
                metadata = json.load(contents)
                languages = ""
                if metadata["type"] == "Coding":
                    languages = dirs
                result[root] = (metadatafile, languages)
    return result


def get_problems_count(files):
    """Creates the list of problems in markdown and json files."""
    count = 0
    for item in files.items():
        input_file = open(item[1][0], mode="r", encoding="utf-8")
        text = input_file.read()
        json_parsed = json.loads(text)

        if 'skip_for_problems_list' in json_parsed and json_parsed[
                'skip_for_problems_list'] == "True":
            continue

        count = count + 1
    print(f"Total problems: {count}")


def main():
    """main method."""
    files = find_files()
    get_problems_count(files)


if __name__ == '__main__':
    main()
