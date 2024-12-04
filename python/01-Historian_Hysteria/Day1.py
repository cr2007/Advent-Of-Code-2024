# Advent of Code 2024
# Solution - Day 1 - Historian Hysteria
# Author: CSK

def split_lists(lines: list[str]) -> tuple[list[int], list[int]]:
    left_list: list[int] = []
    right_list: list[int] = []

    for line in lines:
        for i, value in enumerate(line.split()):
            if i % 2 == 0:
                left_list.append(int(value))
            else:
                right_list.append(int(value))

    return sorted(left_list), sorted(right_list)


def main():
    values: list[str] = []
    distances: list[int] = []

    with open("input.txt", "r", encoding="utf-8") as file:
        values = file.read().splitlines()

    left_list, right_list = split_lists(values)

    distances = [
        abs(left_list[i] - right_list[i])
        for i in range(len(values))
    ]

    print(f"Number of values in each list: {len(distances)}")
    print(f"Total Distance between the lists: {sum(distances):,} units")

if __name__ == "__main__":
    main()
