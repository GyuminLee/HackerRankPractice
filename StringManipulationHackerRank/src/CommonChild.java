import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CommonChild {


    static int commonChild(String a, String b){
        int[][] C = new int[a.length()+1][b.length()+1];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    C[i+1][j+1] = C[i][j] + 1;
                } else {
                    C[i+1][j+1] = Math.max(C[i+1][j], C[i][j+1]);
                }
            }
        }

        for (int i = 0; i < a.length()+1; i++) {
            for(int j = 0; j < b.length()+1; j++) {
                System.out.print(C[i][j] +"," );
            }
            System.out.println();
        }

        return C[a.length()][b.length()];
    }


    public static void main(String[] args) {

        String s1 = "HARRY";
        String s2 = "SALLY";
//        String s1 = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS";
//        String s2 = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC";


        int result = commonChild(s1, s2);
        System.out.println("Result : " + result);
    }


}
