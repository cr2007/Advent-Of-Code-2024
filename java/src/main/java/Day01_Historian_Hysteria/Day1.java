package Day01_Historian_Hysteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day1 {
    public static void main(String[] args) {
        List<Integer> leftList, rightList, distances;
        leftList = rightList = distances = new ArrayList<>();

        String filePath = Objects.requireNonNull(
                Day1.class.getResource("/Day1_input.txt")
        ).getPath();
        filePath = URLDecoder.decode(filePath, StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length == 2) {
                    leftList.add(Integer.parseInt(parts[0].trim()));
                    rightList.add(Integer.parseInt(parts[1].trim()));
                } else System.out.println("Skipping invalid line: " + line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        for (int i = 0; i < leftList.size(); i++) distances.add(
                Math.abs(leftList.get(i) - rightList.get(i))
        );

        int sumOfDistances = distances.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Number of values in each list: " + distances.size());
        System.out.println("Total distance between the lists: " + String.format("%,d", sumOfDistances));
    }
}
