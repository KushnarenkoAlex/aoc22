package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Day8 {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day8Input.txt");
        char[][] characters = Arrays.stream(Resources.toString(url, StandardCharsets.UTF_8)
                        .split("\n"))
                .map(String::toCharArray).toArray(char[][]::new);


        int result1 = 0;
        int result2 = 0;

        for (int i = 0; i < characters.length; i++) {
            if (i == 0 || i == characters.length - 1) {
                result1 += characters[i].length;
            } else {
                char[] line = characters[i];
                for (int j = 0; j < line.length; j++) {
                    if (j == 0 || j == line.length - 1) {
                        result1++;
                    } else {
                        boolean visibleH = false, visibleW = false;
                        char tree = line[j];
                        int treeScore = 1;
                        for (int j1 = j + 1; j1 < line.length; j1++) {
                            if (tree <= line[j1]) {
                                treeScore *= j1 - j;
                                break;
                            } else if (j1 == line.length - 1) {
                                treeScore *= line.length - 1 - j;
                                visibleH = true;
                            }
                        }
                        for (int j2 = j - 1; j2 > -1; j2--) {
                            if (tree <= line[j2]) {
                                treeScore *= j - j2;
                                break;
                            } else if (j2 == 0) {
                                treeScore *= j;
                                visibleH = true;
                            }
                        }
                        for (int i1 = i + 1; i1 < characters.length; i1++) {
                            if (tree <= characters[i1][j]) {
                                treeScore *= i1 - i;
                                break;
                            } else if (i1 == characters.length - 1) {
                                treeScore *= characters.length - 1 - i;
                                visibleW = true;
                            }
                        }
                        for (int i2 = i - 1; i2 > -1; i2--) {
                            if (tree <= characters[i2][j]) {
                                treeScore *= i - i2;
                                break;
                            } else if (i2 == 0) {
                                treeScore *= i;
                                visibleW = true;
                            }
                        }
                        if (visibleH || visibleW) {
                            result1++;
                        }
                        if (treeScore > result2) {
                            result2 = treeScore;
                        }
                    }
                }
            }
        }


        System.out.println(result1);
        System.out.println(result2);
    }
}
