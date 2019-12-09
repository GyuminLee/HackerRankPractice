import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class SherlockAndValidString {
    static String isValid3(String s) {
        if ( s == null || s.length ()<=2 ) return "YES";
        HashMap <Character, Integer> countMap = new HashMap <Character, Integer> ();
        for ( char c : s.toCharArray ()){
            countMap.put (c, countMap.getOrDefault(c,0) + 1);
        }

        // Now, use a second hashmap:
        // Number of times a letter appears -> Number of different letters for which it appears.
        // For the string to be valid, there should be at most 2 keys,
        // and the smallest key is either 1 or the max key - 1,
        // and the value for the smallest key must be 1.
        HashMap <Integer, Integer> freqToDiffLetters = new HashMap <Integer, Integer> ();
        Iterator < Character > iter = countMap.keySet().iterator();

        while ( iter.hasNext()){
            int freq = countMap.get(iter.next()); // Get the frequency.
            freqToDiffLetters.put(freq, freqToDiffLetters.getOrDefault(freq, 0) + 1);
        }

        // Finally, analyze this HashMap.
        if (freqToDiffLetters.keySet().size() > 2 ) return "NO";
        if (freqToDiffLetters.keySet().size() == 1 ) return "YES";

        Iterator< Integer > iter2 = freqToDiffLetters.keySet().iterator();
        iter2 = freqToDiffLetters.keySet().iterator();
        int freq1 = iter2.next();
        int freq2 = iter2.next();

        if ( freq1 > freq2 ){
            int temp = freq1;
            freq1 = freq2;
            freq2 = temp;
        }

        if ( freq1 == 1 ){
            return ( freqToDiffLetters.get(freq1) == 1?"YES":"NO");
        }
        if ( freq2 == freq1 + 1 ){
            return ( freqToDiffLetters.get(freq2) == 1 )?"YES":"NO";
        }
        return "NO";

    }
    static String isValid2(String s) {
        Map<String, Integer> charMap = new HashMap<String, Integer>();
       for(int i = 0; i < s.length(); i++) {
           if(charMap.containsKey(s.charAt(i)+"")) {
               charMap.put(s.charAt(i)+"", charMap.get(s.charAt(i)+"") + 1);
           } else {
               charMap.put(s.charAt(i)+"", 1);
           }
       }

       int maxNum = Integer.MIN_VALUE;
       int minNum = Integer.MAX_VALUE;

       for(String str : charMap.keySet()) {
           System.out.println("Str : " + str + " / Value : " + charMap.get(str));
           if( minNum > charMap.get(str)){
               minNum = charMap.get(str);
           }
           if(maxNum < charMap.get(str)) {
               maxNum = charMap.get(str);
           }
       }
       int minCnt = 0;
       int maxCnt = 0;

       for(String str : charMap.keySet()) {
           if( minNum == charMap.get(str)){
               minCnt++;
           }
           if( maxNum == charMap.get(str)){
               maxCnt++;
           }
       }
        System.out.println("minNum : " + minNum);
        System.out.println("maxNum : " + maxNum);
        System.out.println("minCnt : " + minCnt);
        System.out.println("maxCnt : " + maxCnt);
       if((Math.abs(maxCnt - minCnt) == 1 &&  maxNum-minNum == 1) && (minCnt == 1 || maxCnt ==1) ||
               (minCnt == 1 && minNum == 1)
               || (maxCnt == 1 && minCnt > 1 && maxNum-minNum == 1)) {
           return "YES";
       } else {
           return "NO";
       }
//
    }
    // Complete the isValid function below.
    static String isValid(String s) {

        //Approach1. Array (c - 'a') index
        int[] cntArr = new int [26];
        char[] charArr = s.toCharArray();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        int maxCnt = 0;
        int minCnt = 0;

        for(char c: charArr) { // set array
            cntArr[c - 'a']++;
        }

        for(int i = 0; i < cntArr.length; i++) {
            System.out.println(cntArr[i]);
        }

        for(int i = 0; i < cntArr.length; i++) {
            if(minValue > cntArr[i] && cntArr[i] != 0) {
                minValue = cntArr[i];
            }
            if(maxValue < cntArr[i]) {
                maxValue = cntArr[i];
            }
        }

        for(int i = 0; i < cntArr.length; i++) {
            if(cntArr[i] == maxValue) {
                maxCnt++;
            }
            if(cntArr[i] == minValue) {
                minCnt++;
            }
        }

        System.out.println("minValue : " + minValue);
        System.out.println("maxValue : " + maxValue);
        System.out.println("minCnt : " + minCnt);
        System.out.println("maxCnt : " + maxCnt);

        if(((maxCnt == 1 || minCnt == 1) && maxValue - minValue == 1) ||
                (minValue == 1 && minCnt == 1) ){
            return "YES";
        } else {
            return "NO";
        }

    }


    public static void main(String[] args) {
//        String s = "aabbccddeefghi";
// NO
//        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        //YES
        String s = "abcdefghhgfedecba";
        //
//        String s = "xxxaabbccrry";
        String result = isValid(s);
        System.out.println("Result : " + result);

    }
}

