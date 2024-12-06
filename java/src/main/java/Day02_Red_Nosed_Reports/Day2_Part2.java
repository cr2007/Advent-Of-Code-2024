package Day02_Red_Nosed_Reports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class Day2_Part2 {
    public static void main(String[] args) {
        int safeReports = 0;

        String filePath = Objects.requireNonNull(
                Day2_Part2.class.getResource("/Day2_input.txt")
        ).getPath();
        filePath = URLDecoder.decode(filePath, StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                int[] report = Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                if (checkReportSafety(report)) safeReports++;
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

        System.out.println("Number of safe reports: " + safeReports);
    }

    private static boolean checkReportSafety(int[] report) {
        // If the report is safe without removing any level, return True
        if (isSafeSequence(report)) return true;

        // Removes a single level to see if it is safe
        for (int i = 0; i < report.length; i++) {
            int[] newReport = new int[report.length - 1];

            // Creates a new array without the value at 'i'
            System.arraycopy(report, 0, newReport, 0, i);
            System.arraycopy(report, i + 1, newReport, i, report.length - i - 1);

            // Returns true if the report is safe by removing that level
            if (isSafeSequence(newReport)) return true;
        }

        // The report is unsafe, regardless of which level is removed
        return false;
    }

    private static boolean isSafeSequence(int[] report) {
        boolean isIncreasing = report[1] > report[0];

        for (int i = 1; i < report.length; i++) {
            int difference = Math.abs(report[i] - report[i - 1]);

            if (difference < 1 || difference > 3) return false;

            if ((report[i] > report[i - 1]) != isIncreasing) return false;
        }

        return true;
    }
}
