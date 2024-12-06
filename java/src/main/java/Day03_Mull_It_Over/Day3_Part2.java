package Day03_Mull_It_Over;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day3_Part2 {
    private static final Pattern MUL_PATTERN = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");

    public static void main(String[] args) {
        boolean enabled = true;
        int totalSum = 0;

        String filePath = Objects.requireNonNull(
                Day3_Part2.class.getResource("/Day3_input.txt")
        ).getPath();
        filePath = URLDecoder.decode(filePath, StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                Matcher matcher = MUL_PATTERN.matcher(line);

                while (matcher.find()) {
                    if (matcher.group(0).equals("do()")) enabled = true;
                    else if (matcher.group(0).equals("don't()")) enabled = false;
                    else if (enabled) {
                        int num1 = Integer.parseInt(matcher.group(1));
                        int num2 = Integer.parseInt(matcher.group(2));

                        totalSum += num1 * num2;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

        System.out.println("Sum of products of `mul` instructions: " + String.format("%,d", totalSum));
    }
}
