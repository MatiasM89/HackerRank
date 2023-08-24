package NonDivisibleSubset;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    //absolutely terrifying task, could not figure it out for much longer than I expected

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] arr = new int[k];
        int counter = 0;
        for (Integer x : s) {
            arr[x % k]++;
        }
        if (arr[0] != 0) {
            counter++;
        }
        if (k % 2 == 0 && arr[k / 2] > 0) {
            counter++;
            arr[k / 2] = 0;
        }
        for (int i = 1; i <= (k / 2); i++) {
            counter += Math.max(arr[i], arr[k - i]);
        }

        return counter;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
