package LeetCode.LeastUniqueIntegers1481;

import java.util.*;

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> numberCounter = new HashMap<>();
        for (int num : arr) {
            if (numberCounter.containsKey(num)) {
                numberCounter.put(num, numberCounter.get(num) + 1);
            } else {
                numberCounter.put(num, 1);
            }
        }
        int removalCounter = 0;
        List<Integer> listOfValues = new ArrayList<>(numberCounter.values());
        listOfValues.sort(Comparator.naturalOrder());
        int i = 0;
        while (k > 0) {
            k = k - listOfValues.get(i);
            if (k >= 0) {
                removalCounter++;
            }
            i++;
        }
        return numberCounter.size() - removalCounter;
    }
}
