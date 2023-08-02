package BetweenTwoSets;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {


    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int resultNumber = 0;
        int maxOfB = Collections.max(b);
        int i = 1;
        while (i <= maxOfB) {
            final int currentI = i;
            if(!a.stream().allMatch(number -> currentI % number == 0)) {
                i++;
                continue;
            }
            boolean allFactors = b.stream().allMatch(number -> (number % currentI) == 0);
            if (allFactors) {
                resultNumber++;
            }
            i++;
        }
        return resultNumber;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
