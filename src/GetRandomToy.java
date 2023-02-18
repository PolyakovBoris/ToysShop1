import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class GetRandomToy {
    public static void getToy() {

        DeleteEmptyCategoriesToys.checkEmptyCaterories();
        ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("ToysList.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ArrayList<Integer> amount = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).length() > 0) {
                String[] element = lines.get(i).split(" ");
                amount.add(Integer.parseInt(element[1]));
            }
        }
        int sum = amount.stream().mapToInt(Integer::valueOf).sum();
        for (int i = 0; i < amount.size(); i++) {
            amount.set(i, ThreadLocalRandom.current().nextInt(100 / sum * amount.get(i)));
        }
        PutToys.put((amount.indexOf(Collections.max(amount))) + 1);
    }
}
