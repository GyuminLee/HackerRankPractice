import java.util.*;


public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int result = 0;
        int[] letterCount = new int[26];
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        for(char c : arrayA) {
            letterCount[c - 'a']++;
        }
        for(char c : arrayB) {
            letterCount[c - 'a']--;
        }

        for(int i : letterCount) {
            i = Math.abs(i);
            result += i;
        }

        return result;
    }


    public static void main(String[] args) {

        String a = "cde";

        String b = "abc";

        int res = makeAnagram(a, b);

        System.out.println("Result : " + res);

    }
}
