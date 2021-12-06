package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileUtil {

    public static String readFileAsString(String file) {
        System.out.println("Calling readFileAsString \n " + file);
        try {
            return new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            System.out.println("Error readFileAsString \n " + e);
            e.printStackTrace();
            return null;
        }
    }
}
