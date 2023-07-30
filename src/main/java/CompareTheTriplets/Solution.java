package CompareTheTriplets;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        if (a.get(0) > b.get(0)) {
            result.set(0, 1);
        } else if (b.get(0) > a.get(0)) {
            result.set(1, 1);
        }
        if (a.get(1) > b.get(1)) {
            result.set(0, result.get(0) + 1);
        } else if (b.get(1) > a.get(1)) {
            result.set(1, result.get(1) + 1);
        }
        if (a.get(2) > b.get(2)) {
            result.set(0, result.get(0) + 1);
        } else if (b.get(2) > a.get(2)) {
            result.set(1, result.get(1) + 1);
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

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
