import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PutToys {
    /**
    создание списка игрушек для розыгрыша в файле
    */
    public static void put(int toyAmount, String toyName){
        File file = new File("ToysList.txt");

        //create the file.
        try {
            if (file.createNewFile()){
                System.out.println("файл создан");
            } else{
                System.out.println("файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("файл уже существует");
        }
        //write content
        Path path = Paths.get("ToysList.txt");
        int iDToy = GetLastStringNumber.getLaststringNum(path) + 1;
        String text = iDToy + " " + toyAmount + " " + toyName;
        try {
            if (iDToy == 1){
                Files.write(path, text.getBytes(), StandardOpenOption.CREATE);
                System.out.println("новая запись произведена");
            } else {
                text = + iDToy + " " + toyAmount + " " + toyName + "\n";
                Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
                System.out.println("запись произведена");
            }
        } catch (IOException e) {
            System.out.println("запись не произведена");;
        }
    }
    /**
     * перезапись файла после розыгрыша
     * @param id
     * @return
     */
    public static void put(int id){

        DeleteEmptyCategoriesToys.checkEmptyCaterories();
        Path path = Paths.get("ToysList.txt");
        List lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
        }
//перебираете циклом

        for(Object s : lines)
            {
            String[] words = s.toString().split(" ");
            if ( words[0].equals(String.valueOf(id))){
                System.out.println("выйгрыш - " + words[2]);
                                s = words[0] + " " + (Integer.parseInt(words[1]) - 1) + " " + words[2];
                lines.set(id-1, s.toString());
            }
        }
        System.out.println("осталось :" + lines);
        try {
            Files.write(path, lines, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
