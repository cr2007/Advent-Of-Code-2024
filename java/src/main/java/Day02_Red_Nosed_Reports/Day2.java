package Day02_Red_Nosed_Reports;

import Day01_Historian_Hysteria.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class Day2 {
    public static void main(String[] args) {
        int safeReports = 0;

        String filePath = Objects.requireNonNull(
                Day1.class.getResource("/Day2_input.txt")
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

    private static Boolean checkReportSafety(int[] report) {
        Boolean isIncreasing = null;

        for (int i = 1; i < report.length; i++) {
            int difference = Math.abs(report[i] - report[i - 1]);

            if (difference < 1 || difference > 3) return false;

            if (isIncreasing == null) isIncreasing = report[i] > report[i - 1];

            else if ((report[i] > report[i - 1]) != isIncreasing) return false;
        }

        return true;
    }
}
