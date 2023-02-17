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

        sumOfWeight += Integer.parseInt(lines.iterator());




//        Path path = Paths.get("ToysList.txt");

    }
}
