package BreakingTheRecords;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        int max = scores.get(0);
        int min = scores.get(0);
        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) > max) {
                results.set(0, results.get(0) + 1);
                max = scores.get(i);
            }
            if (scores.get(i) < min) {
                results.set(1, results.get(1) + 1);
                min = scores.get(i);
            }
        }
        return results;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
