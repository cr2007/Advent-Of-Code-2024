# Advent of Code 2024
# Solution - Day 2, Part 2 - Red-Nosed Reports
# Author: CSK

def is_safe_sequence(report: list[int]) -> bool:
    is_increasing = report[1] > report[0]

    for i in range(1, len(report)):
        diff = abs(report[i] - report[i-1])

        if diff < 1 or diff > 3:
            return False

        if (report[i] > report[i-1]) != is_increasing:
            return False

    return True

def check_report_safety(report: list[int]) -> bool:
    if is_safe_sequence(report):
        return True

    for i in range(len(report)):
        new_report = report[:i] + report[i+1:]
        if is_safe_sequence(new_report):
            return True

    return False


def main():
    safe_reports: int = 0

    with open("input.txt", "r") as file:
        for line in file:
            safe_reports += 1 if check_report_safety(
                [int(x) for x in line.split()]
            ) else 0

    print(f"Number of safe reports: {safe_reports}")


if __name__ == "__main__":
    main()
