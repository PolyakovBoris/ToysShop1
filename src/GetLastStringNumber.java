import java.io.*;
import java.nio.file.Path;
import java.security.Timestamp;
import java.util.List;

public class GetLastStringNumber {
    public static int getLaststringNum(Path path) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(path.toFile());
        } catch (FileNotFoundException e) {

        }

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String str1;
        String str2 = "";

        while (true) {

            try {
                if (!((str1 = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            str2 = str1;
        }
        String[] words = str2.split(" ");
        int iD = (str2.length() > 0 ) ? Integer.parseInt(words[0]) : 0;
        System.out.println(iD);
        return iD;
    }
}



