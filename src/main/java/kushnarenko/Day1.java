package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Day1 {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day1Input.txt");
        String[] input = Resources.toString(url, StandardCharsets.UTF_8).split("\n\n");

        int result1 = Arrays.stream(input).map(s ->
                        Arrays.stream(s.split("\n"))
                                .mapToInt(Integer::parseInt)
                                .sum())
                .max(Integer::compare).orElse(0);

        System.out.println(result1);

        int result2 = Arrays.stream(input).map(s ->
                        Arrays.stream(s.split("\n"))
                                .mapToInt(Integer::parseInt)
                                .sum())
                .sorted((o1, o2) -> o2 - o1)
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(result2);
    }
}
