package FairRations;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static String fairRations(List<Integer> B) {
        int oddCount = 0;
        for (Integer x : B) {
            if (x % 2 == 1) {
                oddCount++;
            }
        }
        if (oddCount % 2 == 1) {
            return "NO";
        }
        int incrementCounter = 0;

        for (int i = 0; i < B.size() - 1; i++) {
            if (B.get(i) % 2 == 1) {
                B.set(i, B.get(i) + 1);
                B.set(i + 1, B.get(i + 1) + 1);
                incrementCounter++;
            }
        }
        return String.valueOf(incrementCounter * 2);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
