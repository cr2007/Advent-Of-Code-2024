# Advent of Code 2024
# Solution - Day 1, Part 2 - Historian Hysteria
# Author: CSK

import timeit

def split_lists(lines: list[str]) -> tuple[list[int], list[int]]:
    left_list, right_list = [], []

    for line in lines:
        # Split the line and convert into integers
        values: list[int] = list(map(int, line.split()))

        # Split the values according to odd and even indices
        left_list.extend(values[::2])
        right_list.extend(values[1::2])

    # Return sorted lists
    return sorted(left_list), sorted(right_list)


def main():
    values: list[str] = []

    with open("input.txt", "r", encoding="utf-8") as file:
        values = file.read().splitlines()

    # Splits the values and returns the sorted lists
    left_list, right_list = split_lists(values)

    # Calculates similarity score for the 2 lists
    similarity_score: list[int] = [value * right_list.count(value) for value in left_list]

    # Prints the total similarity score
    print(f"Total Similarity score: {sum(similarity_score):,}")

if __name__ == "__main__":
    main()
