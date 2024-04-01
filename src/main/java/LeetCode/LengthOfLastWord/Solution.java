package LeetCode.LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        int counter = 0;
        boolean encounteredWhitespace = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && encounteredWhitespace) {
                counter = 1;
                encounteredWhitespace = false;
                continue;
            }

            if (s.charAt(i) != ' ') {
                counter++;
            } else {
                encounteredWhitespace = true;
            }

        }
        return counter;
    }
}
