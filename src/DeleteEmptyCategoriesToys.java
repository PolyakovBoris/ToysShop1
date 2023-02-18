import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DeleteEmptyCategoriesToys {
    public static void checkEmptyCaterories(){

        int deleteIndex = -1;
        Path path = Paths.get("ToysList.txt");
        List lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
        }
        //перебираете циклом
        if (lines.size() < 2) {
            System.out.println("призов нет");
            System.exit (1);
        }
        for(Object stroke : lines)
        {
            String[] words = stroke.toString().split(" ");
            if (words.length > 1) {
                if (Integer.valueOf(words[1]) == 0) {
                    deleteIndex = Integer.parseInt(words[0]);
                }
            }
        }
        if (deleteIndex >= 0) lines.remove(deleteIndex - 1);
        int newId = 1;
        for(Object s : lines) {
            String[] words = s.toString().split(" ");
            words[0] = String.valueOf(newId);
            if (words.length > 1) {
                s = newId + " " + words[1] + " " + words[2];
            }
            lines.set(newId - 1, s.toString());
            newId += 1;
        }
        try {
            Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
