# Advent of Code 2024
# Solution - Day 3, Part 2 - Mull It Over
# Author: CSK

import re

MUL_PATTERN = re.compile(r"mul\((\d+),(\d+)\)|do\(\)|don't\(\)")

def main():
    total_sum: int = 0
    enabled: bool = True

    with open("input.txt", "r", encoding="utf-8") as file:
        for line in file:
            for match in MUL_PATTERN.finditer(line):
                if match.group(0) == "do()":
                    enabled = True
                elif match.group(0) == "don't()":
                    enabled = False
                elif enabled:
                    total_sum += int(match.group(1)) * int(match.group(2))

    print(f"Sum of products of `mul` instructions: {total_sum:,}")

if __name__ == "__main__":
    main()
