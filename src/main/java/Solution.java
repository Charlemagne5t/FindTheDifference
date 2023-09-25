import java.util.HashMap;
import java.util.Map;

class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer count = map.getOrDefault(t.charAt(i), 0);
            count++;
            map.put(t.charAt(i), count);
        }


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                return ch;
            }
            Integer count = map.get(ch);
            count--;
            if (count == 0) {
                map.remove(ch);
            } else map.put(ch, count);

        }

        return map.keySet().iterator().next();
    }
}
