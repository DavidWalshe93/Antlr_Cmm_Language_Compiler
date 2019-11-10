import csv
import os
import subprocess
import sys

TOKEN_FILE_NAME = "temp_token_output.txt"


def run_java(input_file):
    global TOKEN_FILE_NAME
    java_jre = os.environ["java"]
    java_classpath = "-classpath \"C:\\Users\\David\\Google Drive\\CIT\\Modules\\Programming Langauge Design\\mini-compiler\\bin;" \
                     "C:\\Users\\David\\Google Drive\\CIT\\Modules\\Programming Langauge Design\\mini-compiler\\antlr-4.7-complete.jar\""
    java_program = f"\"TestRigTokens_Lab_04\" {input_file} > {TOKEN_FILE_NAME}\""
    java_call = f"{java_jre} {java_classpath} {java_program}"
    subprocess.call(java_call, shell=True)


def read_token_file():
    global TOKEN_FILE_NAME

    with open(TOKEN_FILE_NAME) as fh:
        return fh.readlines()


def remove_characters(token_file_content):
    char_list_to_remove = ["[", "]", "\n"]
    token_file_content_without_square_brackets = []
    for line in token_file_content:
        for char in char_list_to_remove:
            line = "".join([letter for letter in line if letter != char])

        token_file_content_without_square_brackets.append(line)

    return token_file_content_without_square_brackets


def separate_token_data_on_comma(token_file_content):
    token_line_elements = []
    for line in token_file_content:
        token_line_elements.append(line.split(","))

    return token_line_elements


def convert_csv_list_to_dict(csv_data_list):
    return_csv_data_list = []
    for csv_data in csv_data_list:
        elements = csv_data[1].split("=")
        character_range, lexeme = elements[0], "".join(elements[1:])
        low, high = character_range.split(":")
        character_size = (int(high) - int(low)) + 1
        return_csv_data_list.append(
            {"Sequence Number": csv_data[0],
             "Lexeme Range": character_range,
             "Lexeme Size": character_size,
             "Lexeme": lexeme,
             "Token": csv_data[2],
             "Location": csv_data[3]
             })

    return return_csv_data_list


def prep_data_for_csv(token_file_content):
    token_file_content = remove_characters(token_file_content)
    csv_data_list = separate_token_data_on_comma(token_file_content)
    csv_data_list = convert_csv_list_to_dict(csv_data_list)

    return csv_data_list


def create_csv_file(csv_data):
    cwd = os.getcwd()
    with open(os.path.join(cwd, "output_token.csv"), "w", newline="") as fh:
        csv_file_writer = csv.DictWriter(fh, delimiter=",", fieldnames=csv_data[0].keys())
        csv_file_writer.writeheader()

        for row in csv_data:
            csv_file_writer.writerow(row)


def create_csv_token_file():
    global TOKEN_FILE_NAME
    token_file_content = read_token_file()
    csv_data = prep_data_for_csv(token_file_content)
    create_csv_file(csv_data)


def clean_up_temp_files():
    global TOKEN_FILE_NAME
    os.remove(os.path.join(os.getcwd(), TOKEN_FILE_NAME))


def main():
    input_file = sys.argv[1]
    run_java(input_file)
    create_csv_token_file()
    clean_up_temp_files()


if __name__ == '__main__':
    main()
