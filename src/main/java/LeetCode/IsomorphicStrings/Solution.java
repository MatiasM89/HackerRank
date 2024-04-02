package LeetCode.IsomorphicStrings;


import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> AmapsToB = new HashMap<>();
        HashMap<Character, Character> BIsMappedByA = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentA = s.charAt(i);
            char currentB = t.charAt(i);

            if (AmapsToB.containsKey(currentA) && AmapsToB.get(currentA) != currentB) {
                return false;
            }
            if (BIsMappedByA.containsKey(currentB) && BIsMappedByA.get(currentB) != currentA) {
                return false;
            }
            AmapsToB.put(currentA, currentB);
            BIsMappedByA.put(currentB, currentA);
        }
        return true;
    }
}
