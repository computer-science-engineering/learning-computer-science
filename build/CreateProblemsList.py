"""
Script to get list of all problems by parsing readme.md from all subdirectories under ..\\src\\
pip install markdown
pip install BeautifulSoup4
"""

import os
import re
import markdown
from bs4 import BeautifulSoup

PROBLEMS_LIST_FILE = "build/problems_list.md"

def find_files():
    """Return the list of files to process."""
    result = {}
    root_dir = "src"
    cwd = os.getcwd()
    #print(os.listdir(root_dir))
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            if file.endswith(".md"):
                languages = dirs
                file = os.path.join(cwd, root, file)
                result[root] = (file, languages)
    return result

def create_problems_list(files):
    """Creates the list of problems in markdown file."""
    file_to_update = open(PROBLEMS_LIST_FILE, "w")
    file_to_update.write("# List of problems\n")
    file_to_update.close()
    file_to_update = open(PROBLEMS_LIST_FILE, "a")
    table_header1 = "| Sl. No. | Problem | Origin | Companies | Categories | Tags | Languages |"
    table_header2 = "|---------|---------|--------|-----------|------------|------|-----------|"
    file_to_update.write("\n" + table_header1)
    file_to_update.write("\n" + table_header2)
    count = 0
    for item in files.items():
        count = count+1
        input_file = open(item[1][0], mode="r", encoding="utf-8")
        text = input_file.read()
        html = markdown.markdown(text)
        soup = BeautifulSoup(html, 'html.parser')

        problem_name = soup.contents[0].text

        problem_origin = re.sub('src\\\\', '', item[0]).split('\\')[0]
        problem_origin = cleanup_problem_origin(problem_origin)

        clean_path = os.path.normpath(item[0]).replace("\\", "/")
        link = os.path.join(clean_path)

        categories = get_categories(soup)
        categories_string = ", ".join(categories)

        tags = get_tags(soup)
        tags_string = ", ".join(tags)

        companies = get_companies(soup)
        companies_string = ", ".join(companies)

        languages = item[1][1]
        if "Variants" in languages:
            languages.remove("Variants")
        languages_string = ", ".join(languages)

        text = f"| {count} | [{problem_name}]({link}) | {problem_origin} | {companies_string} | {categories_string} | {tags_string} | {languages_string} |"
        file_to_update.write("\n" + text)
    print(f"Total problems: {count}")
    file_to_update.close()

def cleanup_problem_origin(problem_origin):
    """Return the cleaned up problem origin."""
    origins_to_clean = ["ElementsOfProgrammingInterviews",
                        "CrackingTheCodingInterview",
                        "DataStructuresAlgorithmsYuanbin"]
    if problem_origin in origins_to_clean:
        items = filter(None, re.split("([A-Z][^A-Z]*)", problem_origin))
        return " ".join(items)
    return problem_origin

def get_categories(soup):
    """Return the categories for a problem."""
    result = []
    index = 0
    for content in soup.contents:
        if hasattr(content, 'text') and "Categories" in content.text:
            categories = soup.contents[index+2]
            if categories.name == "h2":
                return result
            else:
                result = categories.text.split('\n')
                result = list(filter(None, result))
        index = index+1
    return result

def get_tags(soup):
    """Return the tags for a problem."""
    result = []
    index = 0
    for content in soup.contents:
        if hasattr(content, 'text') and "Tags" in content.text:
            tags = soup.contents[index+2]
            if tags.name == "h2":
                return result
            else:
                result = tags.text.split('\n')
                result = list(filter(None, result))
        index = index+1
    return result

def get_companies(soup):
    """Return the companies for a problem."""
    result = []
    index = 0
    for content in soup.contents:
        if hasattr(content, 'text') and "Companies" in content.text:
            companies = soup.contents[index+2]
            if companies.name == "h2":
                return result
            else:
                result = companies.text.split('\n')
                result = list(filter(None, result))
        index = index+1
    return result


def main():
    """main method."""
    files = find_files()
    create_problems_list(files)

if __name__ == '__main__':
    main()
