"""
Script to get list of all problems by parsing readme.md from all subdirectories under ..\src\
pip install markdown
pip install BeautifulSoup4
"""

import os
import re
import markdown
from bs4 import BeautifulSoup

problems_list_file = "build/problems_list.md"

def find_files():
    result = {}
    root_dir = "src"
    cwd = os.getcwd()
    #print(os.listdir(root_dir))
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            if file.endswith(".md"):
                file = os.path.join(cwd, root, file)
                result[root] = file
    return result

def create_problems_list(files):
    open(problems_list_file, "w").close() #first clear contents of file
    file_to_update = open(problems_list_file, "a")
    table_header1 = "| Sl. No. | Problem | Origin | Categories | Tags | Companies |"
    table_header2 = "|---------|---------|--------|------------|------|-----------|"
    file_to_update.write("\n" + table_header1)
    file_to_update.write("\n" + table_header2)    
    #print(table_header1)
    #print(table_header2)
    count = 0
    for item in files.items():
        count = count+1
        input_file = open(item[1], mode="r", encoding="utf-8")
        text = input_file.read()
        html = markdown.markdown(text)
        soup = BeautifulSoup(html, 'html.parser')

        problem_name = soup.contents[0].text

        problem_origin = re.sub('src\\\\', '', item[0]).split('\\')[0]

        clean_path = os.path.normpath(item[0]).replace("\\", "/")
        link = os.path.join(clean_path)

        categories = get_categories(soup)
        categories_string = ", ".join(categories)

        tags = get_tags(soup)
        tags_string = ", ".join(tags)

        companies = get_companies(soup)
        companies_string = ", ".join(companies)

        text = f"| {count} | [{problem_name}]({link}) | {problem_origin} | {categories_string} | {tags_string} | {companies_string} |"
        file_to_update.write("\n" + text)
        #print(text)
    print(f"Total problems: {count}")
    file_to_update.close()

def get_categories(soup):
    result = []
    index = 0
    for content in soup.contents:
        if (hasattr(content, 'text') and "Categories" in content.text):
            categories = soup.contents[index+2]
            if (categories.name == "h2"):
                return result
            else:
                result = categories.text.split('\n')  
                result = list(filter(None, result))        
        index = index+1
    return result
       
def get_tags(soup):
    result = []
    index = 0
    for content in soup.contents:
        if (hasattr(content, 'text') and "Tags" in content.text):
            tags = soup.contents[index+2]
            if (tags.name == "h2"):
                return result
            else:
                result = tags.text.split('\n')  
                result = list(filter(None, result))        
        index = index+1
    return result

def get_companies(soup):
    result = []
    index = 0
    for content in soup.contents:
        if (hasattr(content, 'text') and "Companies" in content.text):
            companies = soup.contents[index+2]
            if (companies.name == "h2"):
                return result
            else:
                result = companies.text.split('\n')  
                result = list(filter(None, result))        
        index = index+1
    return result


def main():
    files = find_files()
    create_problems_list(files)

if __name__ == '__main__':
    main()
