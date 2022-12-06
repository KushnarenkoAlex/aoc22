package kushnarenko;

import java.io.FileInputStream;
import java.io.IOException;

public class Day1 {
    public String input = "";

    public Day1() {
        try {
            FileInputStream inputStream = new FileInputStream("foo.txt");
            this.input = IOUtils.toString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
