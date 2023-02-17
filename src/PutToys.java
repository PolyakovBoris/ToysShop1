import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PutToys {
    /**
    создание списка игрушек для розыгрыша в файле
    */
    public static void put(int counter, int toyAmount, String toyName){
        File file = new File("ToysList.txt");

//create the file.
        try {
            if (file.createNewFile()){
                System.out.println("файл создан");
            }
            else{
                System.out.println("файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("файл уже существует");
        }




//write content
        Path path = Paths.get("ToysList.txt");

        int iDToy = GetLastStringNumber.getLaststringNum(path) + 1;

        String text = "\n" + iDToy + " " + toyAmount + " " + toyName;
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
            System.out.println("запись произведена");
        } catch (IOException e) {
            System.out.println("запись не произведена");;
        }
    }

}
