package LeetCode.LongestSubstring;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> listOfUsed = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (listOfUsed.contains(s.charAt(i))) {
                if (maxLength < listOfUsed.size()) {
                    maxLength = listOfUsed.size();
                }
                i = i - listOfUsed.size();
                listOfUsed.clear();
                continue;
            }
            listOfUsed.add(s.charAt(i));
        }
        if (maxLength < listOfUsed.size()) {
            maxLength = listOfUsed.size();
        }

        return maxLength;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }
}
