package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day9 {

    public static void main(String[] args) throws IOException {

        URL url = Resources.getResource("Day9Input.txt");
        String[] input = Resources.toString(url, StandardCharsets.UTF_8)
                .split("\n");

        Set<String> tailCoordinatesSet = new LinkedHashSet<>();
        int size = 5;
        int currentHeadX = 0, currentHeadY = size - 1;
        int currentTailX = 0, currentTailY = size - 1;
        tailCoordinatesSet.add(String.format("%d %d", currentTailY, currentTailX));
        for (String s : input) {
            System.out.println(s);
            String[] commands = s.split(" ");
            String direction = commands[0];
            int movesCount = Integer.parseInt(commands[1]);
            for (int i = 0; i < movesCount; i++) {
                switch (direction) {
                    case "R" -> currentHeadX++;
                    case "L" -> currentHeadX--;
                    case "D" -> currentHeadY++;
                    case "U" -> currentHeadY--;
                }
                int differenceX = currentHeadX - currentTailX, differenceY = currentHeadY - currentTailY;
                if (Math.abs(differenceX) > 1 || Math.abs(differenceY) > 1) {
                    currentTailX = differenceX > 0 ? currentTailX + 1 : differenceX < 0 ? currentTailX - 1 : currentTailX;
                    currentTailY = differenceY > 0 ? currentTailY + 1 : differenceY < 0 ? currentTailY - 1 : currentTailY;
                    tailCoordinatesSet.add(String.format("%d %d", currentTailY, currentTailX));
                }
            }
        }

        System.out.println(tailCoordinatesSet.size());
    }
}
//[., ., X, X, ., .]
//[., ., X, X, X, .]
//[., X, X, X, X, .]
//[., ., ., ., X, .]
//[X, X, X, X, ., .]

//[., ., X, X, ., .]
//[., ., ., X, X, .]
//[., X, X, X, X, .]
//[., ., ., ., X, .]
//[X, X, X, X, ., .]