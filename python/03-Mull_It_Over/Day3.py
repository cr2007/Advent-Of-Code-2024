# Advent of Code 2024
# Solution - Day 3 - Mull It Over
# Author: CSK

import re

MUL_PATTERN = re.compile(r'mul\((\d+),(\d+)\)')

def main():
    total_sum: int = 0

    with open("input.txt", "r", encoding="utf-8") as file:
        for line in file:
            total_sum += sum(
                int(a) * int(b) for a,b in MUL_PATTERN.findall(line)
            )

    print(f"Sum of products of `mul` instructions: {total_sum:,}")

if __name__ == "__main__":
    main()
