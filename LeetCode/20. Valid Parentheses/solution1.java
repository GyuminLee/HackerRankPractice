import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution1 {
    public boolean isValid(String s) {
        List<Character> latestBraket = new ArrayList<Character>();
        Map<Character, Character> braketMap = new HashMap<Character, Character>();
        braketMap.put('(', ')');
        braketMap.put('{', '}');
        braketMap.put('[', ']');

        for (int i = 0; i < s.length() ; i++) {
            if(braketMap.containsKey(s.charAt(i))) {
                latestBraket.add(s.charAt(i));
            } else {
                if(latestBraket.size() == 0  || (braketMap.get(latestBraket.get(latestBraket.size()-1)) != s.charAt(i))) {

                    return false;
                }
                latestBraket.remove(latestBraket.size()-1);

            }
        }

        if(latestBraket.size() > 0) {
            return false;
        }
        return true;
    }
}