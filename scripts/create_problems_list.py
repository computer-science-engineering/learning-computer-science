"""
Script to get list of all problems by parsing readme.md from all subdirectories under ..\\src\\
pip install markdown
pip install BeautifulSoup4
"""

import os
import re
import json
import markdown
from bs4 import BeautifulSoup

PROBLEMS_LIST_FILE_MD = "scripts/problems_list.md"
PROBLEMS_LIST_FILE_JSON = "website/problems_list.json"

PROBLEM_ID_STRING = "Id"
PROBLEM_TYPE_STRING = "Type"
PROBLEM_NAME_STRING = "Name"
PROBLEM_LINK_STRING = "Link"
PROBLEM_ORIGIN_STRING = "Origin"
PROBLEM_COMPANIES_STRING = "Companies"
PROBLEM_CATEGORIES_STRING = "Categories"
PROBLEM_TAGS_STRING = "Tags"
PROBLEM_LANGUAGES_STRING = "Languages"

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

def create_problems_list(files):
    """Creates the list of problems in markdown file."""
    file_to_update_md = open(PROBLEMS_LIST_FILE_MD, "w+")
    file_to_update_md.write("# List of problems\n")
    file_to_update_md.close()
    file_to_update_md = open(PROBLEMS_LIST_FILE_MD, "a")
    table_header1 = f"| {PROBLEM_ID_STRING} | {PROBLEM_TYPE_STRING} | {PROBLEM_NAME_STRING} | {PROBLEM_ORIGIN_STRING} | {PROBLEM_COMPANIES_STRING} | {PROBLEM_CATEGORIES_STRING} | {PROBLEM_TAGS_STRING} | {PROBLEM_LANGUAGES_STRING} |"
    table_header2 = "|-----------------------|---------------------|---------------------|-----------------------|--------------------------|---------------------------|---------------------|--------------------------|"
    file_to_update_md.write("\n" + table_header1)
    file_to_update_md.write("\n" + table_header2)
    count = 0
    data_all = []
    for item in files.items():
        data = {}
        count = count+1
        data[PROBLEM_ID_STRING] = count

        input_file = open(item[1][0], mode="r", encoding="utf-8")
        text = input_file.read()
        jsonParsed = json.loads(text)

        problem_type = jsonParsed["type"]
        data[PROBLEM_TYPE_STRING] = problem_type
        
        problem_name = jsonParsed["name"]
        data[PROBLEM_NAME_STRING] = problem_name

        problem_origin = jsonParsed["origin"]["name"]
        data[PROBLEM_ORIGIN_STRING] = problem_origin

        pathSeparator = os.sep
        clean_path = os.path.normpath(item[0]).replace(pathSeparator, "/")
        link = os.path.join(clean_path)
        data[PROBLEM_LINK_STRING] = link

        companies = filter(None, jsonParsed["companies"])
        companies = list(companies)
        companies_string = ", ".join(companies)
        data[PROBLEM_COMPANIES_STRING] = list(companies)

        categories = filter(None, jsonParsed["categories"])
        categories = list(categories)
        categories_string = ", ".join(categories)
        data[PROBLEM_CATEGORIES_STRING] = categories

        tags = filter(None, jsonParsed["tags"])
        tags = list(tags)
        tags_string = ", ".join(tags)
        data[PROBLEM_TAGS_STRING] = list(tags)

        languages = item[1][1]
        if "Variants" in languages:
            languages.remove("Variants")
        languages_string = ", ".join(languages)
        data[PROBLEM_LANGUAGES_STRING] = languages

        data_all.append(data)

        text = f"| {count} | {problem_type} | [{problem_name}]({link}) | {problem_origin} | {companies_string} | {categories_string} | {tags_string} | {languages_string} |"
        file_to_update_md.write("\n" + text)
    print(f"Total problems: {count}")
    json_data = json.dumps(data_all)#, indent=2)
    file_to_update_json = open(PROBLEMS_LIST_FILE_JSON, "w+")
    file_to_update_json.write(json_data)
    file_to_update_json.close()
    file_to_update_md.close()

def main():
    """main method."""
    files = find_files()
    create_problems_list(files)

if __name__ == '__main__':
    main()
