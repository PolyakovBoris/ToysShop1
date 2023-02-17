
//import PutToys.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        PutToys.put(1, 5, "constructor" );
//        PutToys.put(2, 3, "doll" );
//        PutToys.put(3, 4, "train" );
        try {
            GetRandomToy.getToy();
        } catch (IOException e) {

        }
    }
}