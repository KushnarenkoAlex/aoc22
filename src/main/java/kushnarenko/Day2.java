package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day2 {

    public static void main(String[] args) throws IOException {

        Map<String, Character> values = Map.of(
                "A", 'R',
                "B", 'P',
                "C", 'S',
                "X", 'R',
                "Y", 'P',
                "Z", 'S'
        );
        Map<String, Integer> points = Map.of(
                "X", 1,
                "Y", 2,
                "Z", 3
        );
        Set<String> wins = Set.of("A Y", "B Z", "C X");
        Map<String, String> wins2 = Map.of(
                "A", "Y",
                "B", "Z",
                "C", "X"
        );
        Map<String, String> loss2 = Map.of(
                "A", "Z",
                "B", "X",
                "C", "Y"
        );
        Map<String, String> draw2 = Map.of(
                "A", "X",
                "B", "Y",
                "C", "Z"
        );

        URL url = Resources.getResource("Day2Input.txt");
        String[] input = Resources.toString(url, StandardCharsets.UTF_8)
                .split("\n");

        int result1 = 0, result2 = 0;
        for (String s : input) {
            String[] resultString = s.split(" ");
            if (wins.contains(s)) {
                result1 += 6;
            } else {
                if (values.get(resultString[0]) ==
                        values.get(resultString[1])) {
                    result1 += 3;
                }
            }
            result1 += points.get(resultString[1]);

            String ourMove = resultString[1];
            if (ourMove.equals("Z")) {
                result2 += 6;
                result2 += points.get(wins2.get(resultString[0]));
            } else if (ourMove.equals("Y")) {
                result2 += 3;
                result2 += points.get(draw2.get(resultString[0]));
            } else {
                result2 += points.get(loss2.get(resultString[0]));
            }
        }

        System.out.println(result1);
        System.out.println(result2);


    }
}
