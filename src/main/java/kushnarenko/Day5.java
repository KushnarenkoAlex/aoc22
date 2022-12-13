package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day5 {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day5Input.txt");
        String[] input = Resources.toString(url, StandardCharsets.UTF_8).split("\n\n");
        String[] cratesInput = input[0].split("\n");
        String[] moves = input[1].split("\n");

        Stack<Character>[] crates = new Stack[20];

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cratesInput[cratesInput.length - 1].length(); i++) {
            char numberAt = cratesInput[cratesInput.length - 1].charAt(i);
            if (numberAt != ' ') {
                int parseInt = numberAt - '0';
                Stack<Character> stack = crates[parseInt];
                if (stack == null) {
                    stack = new Stack<>();
                    crates[parseInt] = stack;
                }
                for (int j = cratesInput.length - 2; j >= 0; j--) {
                    char charAt = cratesInput[j].charAt(i);
                    if (charAt != ' ') {
                        stack.add(charAt);
                    }
                }
            }
        }

        for (String move : moves) {
            String[] strings = move.split(" ");
            int movesAmount = Integer.parseInt(strings[1]), from = Integer.parseInt(strings[3]), to = Integer.parseInt(strings[5]);
//            for (int i = 0; i < movesAmount; i++) { Part1
//                crates[to].push(crates[from].pop());
//            }
            for (int i = movesAmount; i >= 1; i--) {
                Stack<Character> crateFrom = crates[from];
                int movingIndex = crateFrom.size() - i;
                if (movingIndex >= 0) {
                    Character character = crateFrom.get(movingIndex);
                    crates[to].push(character);
                    crateFrom.remove(movingIndex);
                }
            }
        }

        Arrays.stream(crates).filter(Objects::nonNull).map(Stack::pop).forEach(result::append);
        System.out.println(result);
    }
}
