package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Day2 {
    public String[] input;

    public Map<String, Character> values;
    public Set<String> wins;
    public Map<String, String> wins2;
    public Map<String, String> loss2;
    public Map<String, String> draw2;
    public Map<String, Integer> points;

    public Day2() {
        this.values = Map.of(
                "A", 'R',
                "B", 'P',
                "C", 'S',
                "X", 'R',
                "Y", 'P',
                "Z", 'S'
        );
        this.points = Map.of(
                "X", 1,
                "Y", 2,
                "Z", 3
        );
        this.wins = Set.of("A Y", "B Z", "C X");
        this.wins2 = Map.of(
                "A", "Y",
                "B", "Z",
                "C", "X"
        );
        this.loss2 = Map.of(
                "A", "Z",
                "B", "X",
                "C", "Y"
        );
        this.draw2 = Map.of(
                "A", "X",
                "B", "Y",
                "C", "Z"
        );
        try {
            URL url = Resources.getResource("Day2Input.txt");
            this.input = Resources.toString(url, StandardCharsets.UTF_8)
                    .split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int part1() {
        int points = 0;
        for (String s : input) {
            String[] result = s.split(" ");
            if (wins.contains(s)) {
                points += 6;
            } else {
                if (values.get(result[0]) ==
                        values.get(result[1])) {
                    points += 3;
                }
            }
            points += this.points.get(result[1]);
        }
        return points;
    }

    public int part2() {
        int points = 0;
        for (String s : input) {
            String[] result = s.split(" ");
            String ourMove = result[1];
            if (ourMove.equals("Z")) {
                points += 6;
                points += this.points.get(wins2.get(result[0]));
            } else if (ourMove.equals("Y")) {
                points += 3;
                points += this.points.get(draw2.get(result[0]));
            } else {
                points += this.points.get(loss2.get(result[0]));
            }

        }
        return points;
    }
}
