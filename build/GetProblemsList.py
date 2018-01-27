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

def update_problems_list(files):
    open(problems_list_file, "w").close() #first clear contents of file
    file_to_update = open(problems_list_file, "a")
    table_header1 = "| Sl. No. | Problem | Origin | Tags | Companies |"
    table_header2 = "|---------|---------|--------|------|-----------|"
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

        # get problem name
        problem_name = soup.contents[0].text

        # get problem origin
        problem_origin = re.sub('src\\\\', '', item[0]).split('\\')[0]

        clean_path = os.path.normpath(item[0]).replace("\\", "/")
        link = os.path.join(clean_path)
        tags = get_tags(clean_path, soup)
        tags_string = ", ".join(tags)
        companies = get_companies(soup)
        companies_string = ", ".join(companies)
        text = f"| {count} | [{problem_name}]({link}) | {problem_origin} | {tags_string} | {companies_string} |"
        file_to_update.write("\n" + text)
        #print(text)
    print(f"Total problems: {count}")
    file_to_update.close()
       
def get_tags(path, soup):
    result = []
    """
    if "InterviewBit" in path:
        items = path.split("/")
        for item in items:
            if "Level" in  item:
                tag = re.sub('Level\d*_', '', item)
                result.append(tag)
    else:
    """
    index = 0
    for content in soup.contents:
        if (hasattr(content, 'text') and "Tags" in content.text):
            tags = soup.contents[index+2].text  
            result = tags.split('\n')  
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
    update_problems_list(files)

if __name__ == '__main__':
    main()
