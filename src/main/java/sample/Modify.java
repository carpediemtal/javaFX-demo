package sample;

import java.io.*;
import java.util.Objects;

public class Modify {
    public static void modify() throws IOException {
        File mds = new File("D:\\BlogForServer\\blog\\source\\_posts");
        for (File file : Objects.requireNonNull(mds.listFiles())) {
            modify(file);
        }
    }

    private static void modify(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("<img")) {
                line = "<img " + "referrerpolicy=\"no-referrer\" " + line.substring(5);
            }
            content.append(line).append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content.toString());
        writer.flush();
    }
}
