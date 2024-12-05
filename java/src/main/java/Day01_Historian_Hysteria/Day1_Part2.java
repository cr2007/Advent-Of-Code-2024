package Day01_Historian_Hysteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day1_Part2 {
    public static void main(String[] args) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> similarityScore = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        String filePath = Objects.requireNonNull(
                Day1_Part2.class.getResource("/Day1_input.txt")
        ).getPath();
        filePath = URLDecoder.decode(filePath, StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length == 2) {
                    leftList.add( Integer.parseInt( parts[0].trim() ) );
                    rightList.add( Integer.parseInt( parts[1].trim() ) );
                } else System.out.println("Skipping invalid line: " + line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        for (int value : rightList) frequencyMap.put(
                value, frequencyMap.getOrDefault(value, 0) + 1
        );

        for (int value : leftList) similarityScore.add(
                value * frequencyMap.getOrDefault(value, 0)
        );

        int totalSimilarityScore = similarityScore.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Total Similarity Score: " + String.format("%,d", totalSimilarityScore));
    }
}
