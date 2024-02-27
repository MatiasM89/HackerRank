package LeetCode.PhoneLetterCombination;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits.length() == 0) {
            return list;
        }
        list.add("");
        String[] mapping = new String[]{
                "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        for (int i = 0; i < digits.length(); i++) {
            int currentIndex = Character.getNumericValue(digits.charAt(i));
            while (list.peek().length() == i) {
                String temp = list.remove();
                char[] array = mapping[currentIndex].toCharArray();
                for(char c : array){
                    String current = temp + c;
                    list.add(current);
                }
            }
        }
        return list;
    }

}
