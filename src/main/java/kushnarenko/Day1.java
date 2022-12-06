package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Day1 {
    public String[] input;

    public Day1() {
        try {
            URL url = Resources.getResource("Day1Input.txt");
            this.input = Resources.toString(url, StandardCharsets.UTF_8).split("\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int part1() {
        return Arrays.stream(input).map(s ->
                        Arrays.stream(s.split("\n"))
                                .mapToInt(Integer::parseInt)
                                .sum())
                .max(Integer::compare).orElse(0);
    }

    public int part2() {
        return Arrays.stream(input).map(s ->
                        Arrays.stream(s.split("\n"))
                                .mapToInt(Integer::parseInt)
                                .sum())
                .sorted((o1, o2) -> o2 - o1)
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
