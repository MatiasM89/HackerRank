package PickingNumbers;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

//up to this point the most confusing code i`ve learned writing this
class Result {
    public static int pickingNumbers(List<Integer> a) {
        TreeMap<Integer, Integer> occurrenceCounter = new TreeMap<>();
        for (Integer x : a) {
            if (occurrenceCounter.containsKey(x)) {
                occurrenceCounter.put(x, occurrenceCounter.get(x) + 1);
            } else {
                occurrenceCounter.put(x, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = occurrenceCounter.entrySet().iterator();
        Map.Entry<Integer, Integer> currentEntry = iterator.next();
        int sum = currentEntry.getValue();
        while (iterator.hasNext()) {
            int currentKey = currentEntry.getKey();
            int currentValue = currentEntry.getValue();
            int currentSum;
            currentEntry = iterator.next();
            if (Math.abs(currentKey - currentEntry.getKey()) <= 1) {
                currentSum = currentValue + currentEntry.getValue();
            } else {
                currentSum = currentValue;
            }
            if (currentSum > sum) {
                sum = currentSum;
            }
        }
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
