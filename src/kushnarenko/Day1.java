package kushnarenko;

import java.io.FileInputStream;

public class Day1 {
    public static String input = "";

    public Day1() {
        try(FileInputStream inputStream = new FileInputStream("foo.txt")) {
            String everything = IOUtils.toString(inputStream);
            // do something with everything string
        }

    }
}
