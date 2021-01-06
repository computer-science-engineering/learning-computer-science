"""
Script to get list of all problems by parsing readme.md from all subdirectories under ..\\src\\
pip install -r python-requirements.txt
"""

import os
import re
import json
import markdown
from bs4 import BeautifulSoup

PROBLEMS_LIST_FILE_MD = "scripts/problems_list.md"
PROBLEMS_LIST_FILE_JSON = "scripts/problems_list.json"

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
    """Creates the list of problems in markdown and json files."""
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
        input_file = open(item[1][0], mode="r", encoding="utf-8")
        text = input_file.read()
        json_parsed = json.loads(text)

        if 'skip_for_problems_list' in json_parsed and json_parsed[
                'skip_for_problems_list'] == "True":
            continue

        data = {}
        count = count + 1
        data[PROBLEM_ID_STRING] = count

        problem_type = json_parsed["type"]
        data[PROBLEM_TYPE_STRING] = problem_type

        problem_name = json_parsed["name"]
        data[PROBLEM_NAME_STRING] = problem_name

        problem_origin = json_parsed["origin"]["name"]
        data[PROBLEM_ORIGIN_STRING] = problem_origin

        path_separator = os.sep
        clean_path = os.path.normpath(item[0]).replace(path_separator, "/")
        link = os.path.join(clean_path)
        data[PROBLEM_LINK_STRING] = link

        companies = filter(None, json_parsed["companies"])
        companies = list(companies)
        companies_string = ", ".join(companies)
        data[PROBLEM_COMPANIES_STRING] = list(companies)

        categories = filter(None, json_parsed["categories"])
        all_categories = []
        result = get_all_categories(list(categories), all_categories)
        result = filter(None, result)
        result = list(result)
        categories_string = ", ".join(result)
        data[PROBLEM_CATEGORIES_STRING] = result

        tags = filter(None, json_parsed["tags"])
        tags = list(tags)
        tags_string = ", ".join(tags)
        data[PROBLEM_TAGS_STRING] = list(tags)

        languages = item[1][1]
        if "Variants" in languages:
            languages.remove("Variants")
        if "_Variants" in languages:
            languages.remove("_Variants")
        languages_string = ", ".join(languages)
        data[PROBLEM_LANGUAGES_STRING] = languages

        data_all.append(data)

        text = f"| {count} | {problem_type} | [{problem_name}]({link}) | {problem_origin} | {companies_string} | {categories_string} | {tags_string} | {languages_string} |"
        file_to_update_md.write("\n" + text)
    print(f"Total problems: {count}")
    json_data = json.dumps(data_all)  #, indent=2)
    file_to_update_json = open(PROBLEMS_LIST_FILE_JSON, "w+")
    file_to_update_json.write(json_data)
    file_to_update_json.close()
    file_to_update_md.close()


def get_all_categories(categories, all_categories):
    result = []
    for item in categories:
        categories = get_categories(item)
        if len(categories) > 0:
            all_categories.append(categories)
    for item in all_categories:
        for category in item:
            if len(category) > 0:
                str_temp = ' -> '.join(category)
                result.append(str_temp)
    return result


def get_categories(current_item):
    all_paths = []
    get_categories_recursive(current_item, [], all_paths)
    return all_paths


def get_categories_recursive(current_item, current_category, all_categories):
    if current_item == None or len(current_item) == 0:
        return
    if 'name' in current_item and len(current_item['name']) > 0:
        current_category.append(current_item['name'])
    # Reached the end.
    if 'children' not in current_item or ('children' in current_item and len(
            current_item['children']) == 0) and len(current_category) > 0:
        all_categories.append(list(current_category))
    elif 'children' in current_item and len(current_item['children']) > 0:
        for child in current_item['children']:
            get_categories_recursive(child, current_category, all_categories)
    if len(current_category) > 0:
        del current_category[-1]


def main():
    """main method."""
    files = find_files()
    create_problems_list(files)


if __name__ == '__main__':
    main()
