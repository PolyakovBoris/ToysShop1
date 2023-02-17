import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GetRandomToy {
    public static void getToy() throws IOException {
        ArrayList<String> lines;

        lines = new ArrayList<>(Files.readAllLines(Paths.get("ToysList.txt")));
        System.out.println(lines);
        System.out.println("создан массив");
        int sumOfWeight = 0;
        for (int i = 0; i < lines.size(); i++) {
            sumOfWeight += Integer.parseInt(lines.spliterator());
        }



//        Path path = Paths.get("ToysList.txt");

    }
}
