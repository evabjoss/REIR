package S2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/*
public class test {
    public static void main(String[] args) throws IOException {

        {
            Random rand = new Random();
            FileWriter myWriter = new FileWriter("C:\\Users\\maria\\Desktop\\HRh20\\REIR\\S-verkefni\\S2\\REIR\\src\\S2\\testinput\\input150.txt");
            for (int i = 0; i < 150; i++) {
                //System.out.format(" %d  %d\n", rand.nextInt(150), rand.nextInt(150));
                //System.out.printf(" %d  %d\n", rand.nextInt(150), rand.nextInt(150));
                myObj.write(" %d  %d\n", rand.nextInt(150), rand.nextInt(150));
            }
            System.out.println();
            myWriter.close();
        }
    }
}*/


public class test {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i=0; i<12800; i++)
        {
            //System.out.format(" %d  %d\n", rand.nextInt(150), rand.nextInt(150));
            System.out.printf(" %d  %d\n", rand.nextInt(150), rand.nextInt(150));
        }
        System.out.println();
    }
}

