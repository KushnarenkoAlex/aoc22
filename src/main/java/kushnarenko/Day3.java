package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day3Input.txt");
        String[] input = Resources.toString(url, StandardCharsets.UTF_8)
                .split("\n");

        int result1 = 0, result2 = 0;
        List<String> group = new ArrayList<>();
        for (String r : input) {
            group.add(r);
            String c1 = r.substring(0, r.length() / 2), c2 = r.substring(r.length() / 2);
            List<Character> char1 = findCommonChars(c1, c2);
            if (group.size() == 3) {
                List<Character> commonChars = findCommonChars(group.get(1), group.get(2));
                returnCommon(group.get(0), commonChars);
                result2 += getCharPriority(commonChars.get(0));
                group.clear();
            }
            result1 += getCharPriority(char1.get(0));
        }
        System.out.println(result1);
        System.out.println(result2);
    }

    private static int getCharPriority(Character character) {
        if (character >= 97) {
            return character - 96;
        } else {
            return character - 38;
        }
    }

    private static List<Character> findCommonChars(String c1, String c2) {
        List<Character> char1 = new ArrayList<>(c1.chars().mapToObj(e -> (char) e).toList());
        returnCommon(c2, char1);
        return char1;
    }

    private static void returnCommon(String c2, List<Character> char1) {
        List<Character> char2 = c2.chars().mapToObj(e -> (char) e).toList();
        char1.retainAll(char2);
    }
}
