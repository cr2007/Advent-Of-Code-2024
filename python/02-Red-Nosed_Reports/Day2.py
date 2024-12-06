# Advent of Code 2024
# Solution - Day 2 - Red-Nosed Reports
# Author: CSK

def check_report_safety(report: list[int]) -> bool:
    is_increasing: bool = report[1] > report[0]

    for i in range(1, len(report)):
        diff = abs(report[i] - report[i-1])

        if diff < 1 or diff > 3:
            return False

        if (report[i] > report[i-1]) != is_increasing:
            return False

    return True


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
