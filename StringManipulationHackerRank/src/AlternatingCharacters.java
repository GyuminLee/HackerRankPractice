import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.



    static int alternatingCharacters(String s) {
        int result = 0;
        char[] arrayS = s.toCharArray();

        for(int i = 0; i < arrayS.length; i++) {
            if(i > 0) {
                if(arrayS[i-1] == arrayS[i]) {
                    result++;
                }
            }
        }


        return result;
    }



    public static void main(String[] args) {
        String s = "AAA";

        int result = alternatingCharacters(s);

        System.out.println("Result : " + result);
    }
}
