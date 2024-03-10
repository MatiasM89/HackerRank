package LeetCode.RepeatedStringMatch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int repeatedStringMatch(String a, String b) {

        StringBuilder builder = new StringBuilder();
        int count = 1;
        builder.append(a);
        while (builder.length() < b.length()) {
            builder.append(a);
            count++;
        }
        if (builder.toString().contains(b))
            return count;
        count++;
        builder.append(a);
        if (builder.toString().contains(b))
            return count;

        return -1;


//        if (a.length() > b.length()) {
//            if (a.contains(b)) {
//                return 1;
//            } else {
//                return -1;
//            }
//        }
//
//        List<String> substringsOfA = new ArrayList<>();
//        for (int i = 0; i < a.length(); i++) {
//            for (int j = i; j < a.length(); j++) {
//                substringsOfA.add(a.substring(i, j + 1));
//            }
//        }
//        substringsOfA = substringsOfA.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
//
//        int counter = 0;
//        int startIndex = 0;
//        int endIndex = 0;
//        String currentPart;
//
//
//        while (endIndex < b.length()) {
//            endIndex += a.length();
//            if (endIndex > b.length()) {
//                endIndex = b.length();
//            }
//            currentPart = b.substring(startIndex, endIndex);
//            while (!currentPart.isEmpty()) {
//                if (currentPart.length() == 1 && !substringsOfA.contains(currentPart))
//                    return -1;
//                if (substringsOfA.contains(currentPart)) {
//                    counter++;
//                    break;
//                } else {
//                    endIndex--;
//                    currentPart = b.substring(startIndex, endIndex);
//                }
//            }
//            startIndex = endIndex;
//
//        }
//
//        return counter;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.repeatedStringMatch("abcabcabcabc", "abac"));
    }
}
