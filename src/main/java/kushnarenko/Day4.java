package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day4Input.txt");
        String[] input = Resources.toString(url, StandardCharsets.UTF_8).split("\n");

        int result1 = 0, result2 = 0;
        for (String r : input) {
            String[] groups = r.split(",");
            String group1 = groups[0], group2 = groups[1];
            int start1 = Integer.parseInt(group1.split("-")[0]), end1 = Integer.parseInt(group1.split("-")[1]), start2 = Integer.parseInt(group2.split("-")[0]), end2 = Integer.parseInt(group2.split("-")[1]);
            result1 += (start1 <= start2 && end1 >= end2) || (start2 <= start1 && end2 >= end1) ? 1 : 0;
            result2 += start1 <= end2 && start2 <= end1 ? 1 : 0;
        }
        System.out.println(result1);
        System.out.println(result2);
    }
}
