package kushnarenko;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day7 {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day7Input.txt");
        String[] input = Resources.toString(url, StandardCharsets.UTF_8).split("\n");

        Map<String, Integer> fileTree = new HashMap<>();
        String spliterator = ".";
        String currentDir = "";
        for (String s : input) {
            String[] command = s.split(" ");
            if ("$".equals(command[0])) {
                if ("cd".equals(command[1])) {
                    if ("..".equals(command[2])) {
                        int i = currentDir.lastIndexOf(".");
                        currentDir = currentDir.substring(0, i);
                    } else {
                        currentDir = currentDir + spliterator + command[2];
                    }
                }
            } else if (command[0].matches("-?\\d+")) {
                fileTree.put(currentDir, fileTree.getOrDefault(currentDir, 0) + Integer.parseInt(command[0]));
                String sumDirectory = currentDir;
                while (sumDirectory.length() > 0 ){
                    int i = sumDirectory.lastIndexOf(".");
                    sumDirectory = sumDirectory.substring(0, i);
                    fileTree.put(sumDirectory, fileTree.getOrDefault(sumDirectory, 0) + Integer.parseInt(command[0]));
                }

            }
        }

        int res1 = fileTree.keySet().stream().filter(s -> fileTree.get(s) < 100000).map(fileTree::get).mapToInt(Integer::intValue).sum();
        int spaceToGet = 30000000 - (70000000 - fileTree.get(""));
        int res2 = fileTree.keySet().stream().filter(s -> fileTree.get(s) > spaceToGet).map(fileTree::get).mapToInt(Integer::intValue).min().orElse(0);
        System.out.println(fileTree);
        System.out.println(res1);
        System.out.println(spaceToGet);
        System.out.println(res2);
    }
}
