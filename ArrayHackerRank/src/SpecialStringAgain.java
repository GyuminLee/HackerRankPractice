import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SpecialStringAgain {
    public static long substrCount(int length, String s) {
        long counter = 0;
        for (int i = 0; i < length; i++) {
            // if the current symbol is in the middle of palindrome, e.g. aba
            int offset = 1;
            while (i - offset >= 0 && i + offset < length && s.charAt(i - offset) == s.charAt(i - 1)
                    && s.charAt(i + offset) == s.charAt(i - 1)) {
                counter++;
                offset++;
            }
            // if this is repeatable characters aa
            int repeats = 0;
            while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                repeats++;
                i++;
            }
            counter += repeats * (repeats + 1) / 2;
        }
        return counter + length;
    }
    // Complete the substrCount function below.
    static long substrCountWithNsquare(int n, String s) {
        long result = n;
        String debugString = "";
        Set<String> palindromeSet = new HashSet<String>();

        for(int i = 0; i < s.length(); i++) {
            for(int j = n; j > 1; j--) {
                if (i + j < s.length()+1) {
                    System.out.println("testcase : " + s.substring(i, i+j));
                    if(isPalindrom(s.substring(i, i + j))){
                        System.out.println("isPalindrom");
                        debugString += s.substring(i, i + j) + ", ";
                        result++;
                    }
                }
            }
        }
        System.out.println("Debugstring : " + debugString);
        return result;
    }

    static boolean isPalindrom(String s) {
        if(s.length() > 4) {
            if(s.charAt(0) != s.charAt(1)){
                return false;
            }
        }
        if(s.equals(reverseString(s))){
            return true;
        } else {
            return false;
        }
    }

    public static String reverseString(String s) {
        return ( new StringBuffer(s) ).reverse().toString();
    }

    public static void main(String[] args) throws IOException {

        int n = 7;

        String s = "aabaacaaa";

        long result = substrCount(n, s);

        System.out.println("Result : " + result);
        System.out.println("Expected : ");
    }

}
